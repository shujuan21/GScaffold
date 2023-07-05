package com.guany.myscaffold.service;

import com.github.pagehelper.PageInfo;
import com.guany.myscaffold.dto.PermDto;
import com.guany.myscaffold.dto.PermQueryDto;
import com.guany.myscaffold.entity.PermEntity;
import com.guany.myscaffold.entity.UrlEntity;

import java.util.List;

/**
 * 权限
 *
 * @Auther: guany
 * @Date: 2023/04/17
 */
public interface PermService {

    /**
     * 查询所有权限
     *
     * @return 权限列表
     */
    PageInfo<PermEntity> queryPermPageList(PermQueryDto permQueryDto);

    /**
     * 查询权限关联url
     *
     * @param permId 权限id
     * @return url列表
     */
    List<UrlEntity> queryPermUrls(String permId);

    /**
     * 更新权限关联url
     *
     * @param permId 权限id
     * @param urlList url list
     */
    void updatePermUrls(String permId, List<String> urlList);

    /**
     * 新增权限
     *
     * @param permDto 权限信息
     */
    void addPerm(PermDto permDto);

    /**
     * 更新权限
     *
     * @param permDto 权限信息
     */
    void updatePerm(PermDto permDto);

    /**
     * 删除权限
     *
     * @param permId 权限id
     */
    void deletePerm(String permId);
}
