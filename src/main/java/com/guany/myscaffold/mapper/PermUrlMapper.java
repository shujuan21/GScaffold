package com.guany.myscaffold.mapper;

import com.guany.myscaffold.entity.PermUrlEntity;
import com.guany.myscaffold.entity.UrlEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 权限-url关联mapper
 *
 * @Auther: guany
 * @Date: 2023/04/17
 */
public interface PermUrlMapper extends Mapper<PermUrlEntity> {
    /**
     * 查询权限关联url
     *
     * @param permId 权限id
     * @return 权限列表
     */
    List<UrlEntity> selectUrlsByPermId(@Param("permId") String permId);

    /**
     *移除权限关联url
     *
     * @param permId 权限id
     */
    @Update("update t_perm_url set deleted = 1 where perm_id = #{permId} and deleted =0")
    void deleteByPermId(@Param("permId") String permId);
}
