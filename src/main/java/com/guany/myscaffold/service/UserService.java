package com.guany.myscaffold.service;

import com.github.pagehelper.PageInfo;
import com.guany.myscaffold.dto.UserDto;
import com.guany.myscaffold.dto.UserQueryDto;
import com.guany.myscaffold.entity.RoleEntity;
import com.guany.myscaffold.entity.UserEntity;

import java.util.List;

/**
 * @Auther: guany
 * @Date: 2023/04/17
 */
public interface UserService {
    /**
     * 查询用户列表
     * 
     * @param userQueryDto 查询信息
     * @return 用户信息list
     */
    List<UserEntity> queryUserList(UserQueryDto userQueryDto);

    /**
     * 分页查询用户信息
     * 
     * @param userQueryDto 查询信息
     * @return 分页用户信息
     */
    PageInfo<UserEntity> queryUserPageList(UserQueryDto userQueryDto);

    /**
     * 查询当前用户对应的角色
     * 
     * @param userId 用户id
     * @return
     */
    List<RoleEntity> queryUserRoles(String userId);

    /**
     * 新增用户
     * 
     * @param user 用户信息
     */
    void createUser(UserDto user);
    
    /**
     * 删除用户
     * 
     * @param userId 当前用户id
     */
    void deleteUser(String userId);

    /**
     *编辑用户信息
     * 
     * @param user 当前用户
     */
    void updateUser(UserDto user);

    /**
     * 锁定用户
     * 
     * @param userId 当前用户id
     */
    void lockUser(String userId);

    /**
     * 解锁用户
     * 
     * @param userId 当前用户id
     */
    void unlockUser(String userId);

    /**
     * 启用用户
     * 
     * @param userId 当前用户id
     */
    void enableUser(String userId);

    /**
     * 停用用户
     * 
     * @param userId 用户id
     */
    void disableUser(String userId);

    /**
     * 重置用户密码
     *
     * @param userdto 用户dto
     */
    void resetPassword(UserDto userdto);

    /**
     * 更新用户角色信息
     *
     * @param userId 用户id
     * @param roleList 角色list
     */
    void updateUserRole( String userId,List<String> roleList);
}
