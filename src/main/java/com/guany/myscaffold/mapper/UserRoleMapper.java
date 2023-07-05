package com.guany.myscaffold.mapper;

import com.guany.myscaffold.entity.RoleEntity;
import com.guany.myscaffold.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 用户角色mapper
 *
 * @Auther: guany
 * @Date: 2023/04/17
 */
public interface UserRoleMapper extends Mapper<UserRoleEntity> {
    /**
     * 删除用户关联的角色
     * @param userId 用户id
     */
    void deleteByUserId(@Param("userId") String userId);

    /**
     * 查询用户关联角色
     *
     * @param userId 用户id
     * @return 角色list
     */
    List<RoleEntity> selectRolesByUserId(@Param("userId") String userId);
}
