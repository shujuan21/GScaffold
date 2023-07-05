package com.guany.myscaffold.service;

import com.guany.myscaffold.dto.RoleDto;
import com.guany.myscaffold.entity.PermEntity;
import com.guany.myscaffold.entity.RoleEntity;

import java.util.List;

/**
 * 角色
 *
 * @Auther: guany
 * @Date: 2023/04/17
 */
public interface RoleService {
    /**
     * 查询角色列表
     *
     * @return 角色信息list
     */
    List<RoleEntity> queryRoleList();

    /**
     * 查询角色关联权限
     *
     * @param roleId
     * @return 权限信息 list
     */
    List<PermEntity> queryRolePerms(String roleId);

    /**
     * 更新角色关联权限
     * @param roleId 角色id
     * @param permList 权限列表
     */
    void updateRolePerms(String roleId, List<String> permList);

    /**
     * 新增角色
     *
     * @param roleDto 角色信息
     */
    void addRole(RoleDto roleDto);

    /**
     * 删除角色
     *
     * @param roleId 角色id
     */
    void deleteRole(String roleId);

    /**
     * 编辑角色
     *
     * @param roleDto 角色信息
     */
    void updateRole(RoleDto roleDto);

}
