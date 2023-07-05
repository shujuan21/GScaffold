package com.guany.myscaffold.mapper;

import com.guany.myscaffold.entity.PermEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 权限mapper
 *
 * @Auther: guany
 * @Date: 2023/04/17
 */
public interface PermMapper extends Mapper<PermEntity> {
    /**
     * 查询权限
     *
     * @param permCode 权限代码
     * @param permName 权限名称
     * @param permType 权限类型
     */
    List<PermEntity> selectPerm(@Param("permCode") String permCode, @Param("permName")String permName, @Param("permType")String permType);

}
