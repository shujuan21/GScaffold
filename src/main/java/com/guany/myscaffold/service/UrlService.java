package com.guany.myscaffold.service;

import com.github.pagehelper.PageInfo;
import com.guany.myscaffold.dto.UrlDto;
import com.guany.myscaffold.dto.UrlQueryDto;
import com.guany.myscaffold.entity.UrlEntity;

/**
 * url
 *
 * @Auther: guany
 * @Date: 2023/04/17
 */
public interface UrlService {
    /**
     * url列表
     *
     * @param urlQueryDto url查询dto
     * @return 分页url列表
     */
    PageInfo<UrlEntity> queryUrlPageList(UrlQueryDto urlQueryDto);

    /**
     * 新增url
     *
     * @param urlDto url信息
     */
    void createUrl(UrlDto urlDto);

    /**
     * 编辑url信息
     *
     * @param urlDto url信息
     */
    void updateUrl(UrlDto urlDto);

    /**
     * 删除url
     *
     * @param urlId url id
     */
    void deleteUrl(String urlId);
}
