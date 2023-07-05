package com.guany.myscaffold.mapper;

import com.guany.myscaffold.entity.PermEntity;
import com.guany.myscaffold.entity.RolePermEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 角色-权限mapper
 *
 * @Auther: guany
 * @Date: 2023/04/17
 */
public interface RolePermMapper extends Mapper<RolePermEntity> {
    /**
     * 移除角色关联权限
     *
     * @param roleId 角色id
     */
    @Update("update t_role_perm set deleted = 1 where role_id = #{roleId} and deleted = 0")
    void deleteByRoleId(@Param("roleId") String roleId);

    /**
     * 查询角色关联权限
     *
     * @param roleId 角色id
     * @return 权限list
     */
    List<PermEntity> selectPermsByRoleId(@Param("roleId") String roleId);
}
