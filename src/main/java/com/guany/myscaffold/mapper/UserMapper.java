package com.guany.myscaffold.mapper;

import com.guany.myscaffold.entity.PermEntity;
import com.guany.myscaffold.entity.RoleEntity;
import com.guany.myscaffold.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 用户mapper
 *
 * @Auther: guany
 * @Date: 2023/04/17
 */
public interface UserMapper extends Mapper<UserEntity> {

    @Select("select * from t_user where username = #{username} and deleted = 0")
    UserEntity selectByUserName(@Param("username") String username);

    /**
     * 查询登录用户的url权限
     * @param userId
     * @return
     */
    List<String> queryUserUrls(@Param("userId") String userId);

    /**
     * 查询登录用户权限
     * @param userId
     * @return
     */
    List<PermEntity> queryUserPerms(@Param("userId") String userId);

    /**
     * 查询登录用户角色
     * @param userId
     * @return
     */
    List<RoleEntity> queryUserRoles(@Param("userId") String userId);

    /**
     * 查询用户list
     * @param phoneNumber 电话号码
     * @return
     */
    List<UserEntity> selectByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
