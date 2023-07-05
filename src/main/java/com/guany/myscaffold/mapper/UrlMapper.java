package com.guany.myscaffold.mapper;

import com.guany.myscaffold.entity.UrlEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * url
 *
 * @Auther: guany
 * @Date: 2023/04/17
 */
public interface UrlMapper extends Mapper<UrlEntity> {

    /**
     * 查询url
     *
     * @param url url
     * @return url信息
     */
    @Select("select * from t_url where url = #{url} and deleted = 0")
    UrlEntity selectUrl(@Param("url") String url);

}
