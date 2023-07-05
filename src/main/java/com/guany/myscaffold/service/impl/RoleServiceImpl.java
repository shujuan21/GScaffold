package com.guany.myscaffold.service.impl;

import com.guany.myscaffold.common.exception.CustomException;
import com.guany.myscaffold.constant.Constant;
import com.guany.myscaffold.dto.RoleDto;
import com.guany.myscaffold.entity.PermEntity;
import com.guany.myscaffold.entity.RoleEntity;
import com.guany.myscaffold.entity.RolePermEntity;
import com.guany.myscaffold.mapper.PermMapper;
import com.guany.myscaffold.mapper.RoleMapper;
import com.guany.myscaffold.mapper.RolePermMapper;
import com.guany.myscaffold.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色
 *
 * @Auther: guany
 * @Date: 2023/04/17
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Resource
    private PermMapper permMapper;

    @Resource
    private RolePermMapper rolePermMapper;

    @Override
    public List<RoleEntity> queryRoleList() {
        return roleMapper.selectAllRoles();
    }

    @Override
    public List<PermEntity> queryRolePerms(String roleId) {
        return  rolePermMapper.selectPermsByRoleId(roleId);
    }

    @Override
    public void updateRolePerms(String roleId, List<String> permList) {
        RoleEntity roleEntity = roleMapper.selectByPrimaryKey(roleId);
        if(roleEntity == null){
            throw new CustomException("当前角色不存在");
        }
        //删除旧数据，绑定新数据
        rolePermMapper.deleteByRoleId(roleId);
        for(String permId: permList){
            if(permMapper.selectByPrimaryKey(permId) != null){
                RolePermEntity rolePermEntity = new RolePermEntity(roleId, permId);
                rolePermMapper.insert(rolePermEntity);
            }
        }
    }

    @Override
    public void addRole(RoleDto roleDto) {
        if(!roleMapper.selectRole(roleDto.getRoleCode(),null).isEmpty()){
            throw new CustomException("该用户代码已存在");
        }
        if(!roleMapper.selectRole(null,roleDto.getRoleName()).isEmpty()){
            throw new CustomException("该用户名称已存在");
        }
        roleMapper.insert(new RoleEntity(roleDto.getRoleCode(),roleDto.getRoleName()));
    }

    @Override
    public void deleteRole(String roleId) {
        RoleEntity role = roleMapper.selectByPrimaryKey(roleId);
        if(role == null){
            throw new CustomException("该角色不存在");
        }
        role.setDeleted(Constant.DELETED_TRUE_1);
        roleMapper.updateByPrimaryKey(role);

        //删除关联表
        rolePermMapper.deleteByRoleId(roleId);
    }

    @Override
    public void updateRole(RoleDto roleDto) {
        RoleEntity role = roleMapper.selectByPrimaryKey(roleDto.getRoleId());
        if(role == null){
            throw new CustomException("该角色不存在");
        }
        role.setRoleCode(roleDto.getRoleCode());
        role.setRoleName(roleDto.getRoleName());
        roleMapper.updateByPrimaryKey(role);
    }
}
