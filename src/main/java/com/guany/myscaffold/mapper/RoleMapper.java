package com.guany.myscaffold.mapper;

import com.guany.myscaffold.entity.RoleEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 角色mapper
 *
 * @Auther: guany
 * @Date: 2023/04/17
 */
public interface RoleMapper extends Mapper<RoleEntity> {

    /**
     * 查询所有角色
     *
     * @return 角色信息list
     */
    @Select("select * from t_role where deleted = 0 ")
    List<RoleEntity> selectAllRoles();

    /**
     * 查询角色
     *
     * @param roleCode 角色代码
     * @param roleName 角色名称
     */
    List<RoleEntity> selectRole(@Param("roleCode") String roleCode,@Param("roleName") String roleName);
}
