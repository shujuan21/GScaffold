package com.guany.myscaffold.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guany.myscaffold.common.exception.CustomException;
import com.guany.myscaffold.constant.Constant;
import com.guany.myscaffold.constant.UserConstant;
import com.guany.myscaffold.dto.UserDto;
import com.guany.myscaffold.dto.UserQueryDto;
import com.guany.myscaffold.entity.RoleEntity;
import com.guany.myscaffold.entity.UserEntity;
import com.guany.myscaffold.entity.UserRoleEntity;
import com.guany.myscaffold.mapper.RoleMapper;
import com.guany.myscaffold.mapper.UserMapper;
import com.guany.myscaffold.mapper.UserRoleMapper;
import com.guany.myscaffold.service.UserRoleService;
import com.guany.myscaffold.service.UserService;
import com.guany.myscaffold.security.SecurityUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户
 *
 * @Auther: guany
 * @Date: 2023/04/17
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private UserRoleService userRoleService;

    @Override
    public List<UserEntity> queryUserList(UserQueryDto userQueryDto) {
        Example example = new Example(UserEntity.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(userQueryDto.getUsername())){
            criteria.andEqualTo("userName",userQueryDto.getUsername());
        }
        if(StringUtils.isNotBlank(userQueryDto.getEnabled())){
            criteria.andEqualTo("enabled",userQueryDto.getEnabled());
        }
        if(StringUtils.isNotBlank(userQueryDto.getLocked())){
            criteria.andEqualTo("locked",userQueryDto.getLocked());
        }
        criteria.andEqualTo("deleted",Constant.DELETED_FALSE_0);
        return userMapper.selectByExample(example);
    }

    @Override
    public PageInfo<UserEntity> queryUserPageList(UserQueryDto userQueryDto) {
        PageHelper.startPage(userQueryDto.getPageNum(),userQueryDto.getPageSize());
        return new PageInfo<>(queryUserList(userQueryDto));
    }

    @Override
    public List<RoleEntity> queryUserRoles(String userId) {
        return userRoleMapper.selectRolesByUserId(userId);
    }

    @Override
    public void createUser(UserDto userDto) {
        //校验存在
        Example example = new Example(UserEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("phoneNumber",userDto.getPhoneNumber());
        criteria.andEqualTo("deleted",Constant.DELETED_FALSE_0);
        List<UserEntity> list = userMapper.selectByExample(example);
        if(!list.isEmpty()){
            throw new CustomException("用户已存在");
        }
        userDto.setEnabled(UserConstant.ENABLED);
        userDto.setLocked(UserConstant.UNLOCKED);
        userDto.setPassword(SecurityUtil.encryptPassword(userDto.getPassword()));
        userMapper.insert(new UserEntity(userDto));
    }

    @Override
    public void deleteUser(String userId) {
        UserEntity userEntity = userMapper.selectByPrimaryKey(userId);
        if(userEntity == null){
            throw new CustomException("未找到对应的用户信息");
        }
        userEntity.setDeleted(Constant.DELETED_TRUE_1);
        userMapper.updateByPrimaryKey(userEntity);

        //删除关联表
        userRoleMapper.deleteByUserId(userId);
    }

    @Override
    public void updateUser(UserDto user) {
        UserEntity userEntity = userMapper.selectByPrimaryKey(user.getId());
        if(userEntity == null){
            throw new CustomException("未找到对应的用户信息");
        }
        //号码被修改需检查唯一性
        if(!userEntity.getPhoneNumber().equals(user.getPhoneNumber())) {
            List<UserEntity> list = userMapper.selectByPhoneNumber(user.getPhoneNumber());
            if(list.size() > 0)
            userEntity.setPhoneNumber(user.getPhoneNumber());

        }

        userEntity.setUsername(user.getUsername());
        userEntity.setRealName(user.getRealName());
        userEntity.setAddress(user.getAddress());
        userEntity.setBirthday(user.getBirthday());
        userEntity.setSex(user.getSex());
        userMapper.updateByPrimaryKey(userEntity);

    }

    @Override
    public void lockUser(String userId) {
        UserEntity userEntity = userMapper.selectByPrimaryKey(userId);
        if(userEntity == null){
            throw new CustomException("未找到该用户信息");
        }
        userEntity.setLocked(UserConstant.LOCKED);
        userMapper.updateByPrimaryKey(userEntity);
    }

    @Override
    public void unlockUser(String userId) {
        UserEntity userEntity = userMapper.selectByPrimaryKey(userId);
        if(userEntity == null){
            throw new CustomException("未找到该用户信息");
        }
        userEntity.setLocked(UserConstant.UNLOCKED);
        userMapper.updateByPrimaryKey(userEntity);
    }

    @Override
    public void enableUser(String userId) {
        UserEntity userEntity = userMapper.selectByPrimaryKey(userId);
        if(userEntity == null){
            throw new CustomException("未找到该用户信息");
        }
        userEntity.setEnabled(UserConstant.ENABLED);
        userMapper.updateByPrimaryKey(userEntity);
    }

    @Override
    public void disableUser(String userId) {
        UserEntity userEntity = userMapper.selectByPrimaryKey(userId);
        if(userEntity == null){
            throw new CustomException("未找到该用户信息");
        }
        userEntity.setEnabled(UserConstant.DISABLED);
        userMapper.updateByPrimaryKey(userEntity);
    }

    @Override
    public void resetPassword(UserDto userdto) {
        String password = userdto.getPassword();
        if(StringUtils.isBlank(password) && password.length() < 8){
            throw new CustomException("密码格式错误");
        }
        UserEntity userEntity = userMapper.selectByPrimaryKey(userdto.getId());
        if(userEntity == null){
            throw new CustomException("未找到该用户信息");
        }
        userEntity.setPassword(SecurityUtil.encryptPassword(password));
        userMapper.updateByPrimaryKey(userEntity);
    }

    @Override
    public void updateUserRole(String userId, List<String> roleList) {
        UserEntity userEntity = userMapper.selectByPrimaryKey(userId);
        if(userEntity == null){
            throw new CustomException("未找到该用户信息");
        }
        //逻辑删除旧数据
        userRoleMapper.deleteByUserId(userId);
        //新增新数据
        for(String roleId: roleList){
            if(roleMapper.selectByPrimaryKey(roleId) != null){
                UserRoleEntity userRoleEntity = new UserRoleEntity(userId, roleId);
                userRoleMapper.insert(userRoleEntity);
            }
        }
    }
}
