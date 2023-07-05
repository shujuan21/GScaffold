package com.guany.myscaffold.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guany.myscaffold.common.exception.CustomException;
import com.guany.myscaffold.constant.Constant;
import com.guany.myscaffold.dto.UrlDto;
import com.guany.myscaffold.dto.UrlQueryDto;
import com.guany.myscaffold.entity.UrlEntity;
import com.guany.myscaffold.mapper.UrlMapper;
import com.guany.myscaffold.service.UrlService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * url
 *
 * @Auther: guany
 * @Date: 2023/04/17
 */
@Service
public class UrlServiceImpl implements UrlService {
    @Resource
    private UrlMapper urlMapper;

    @Override
    public PageInfo<UrlEntity> queryUrlPageList(UrlQueryDto urlQueryDto) {
        PageHelper.startPage(urlQueryDto.getPageNum(), urlQueryDto.getPageSize());
        Example example = new Example(UrlEntity.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(urlQueryDto.getUrl())){
            criteria.andLike("url", "%" + urlQueryDto.getUrl() + "%");
        }
        criteria.andEqualTo("deleted", Constant.DELETED_FALSE_0);
        return new PageInfo<>(urlMapper.selectByExample(example));
    }

    @Override
    public void createUrl(UrlDto urlDto) {
        if(urlMapper.selectUrl(urlDto.getUrl())!= null){
            throw new CustomException("该url已存在");
        }
        urlMapper.insert(new UrlEntity(urlDto));
    }

    @Override
    public void updateUrl(UrlDto urlDto) {
        UrlEntity urlEntity = urlMapper.selectByPrimaryKey(urlDto.getUrlId());
        if(urlEntity == null){
            throw new CustomException("该url不存在");
        }
        urlEntity.setUrl(urlDto.getUrl());
        urlEntity.setDescri(urlDto.getDescri());
        urlMapper.updateByPrimaryKey(urlEntity);
    }

    @Override
    public void deleteUrl(String urlId) {
        UrlEntity urlEntity = urlMapper.selectByPrimaryKey(urlId);
        if(urlEntity == null){
            throw new CustomException("该url不存在");
        }
        urlEntity.setDeleted(Constant.DELETED_TRUE_1);
        urlMapper.updateByPrimaryKey(urlEntity);
    }
}
