package com.guany.myscaffold.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guany.myscaffold.common.exception.CustomException;
import com.guany.myscaffold.constant.Constant;
import com.guany.myscaffold.dto.PermDto;
import com.guany.myscaffold.dto.PermQueryDto;
import com.guany.myscaffold.entity.PermEntity;
import com.guany.myscaffold.entity.PermUrlEntity;
import com.guany.myscaffold.entity.UrlEntity;
import com.guany.myscaffold.mapper.PermMapper;
import com.guany.myscaffold.mapper.PermUrlMapper;
import com.guany.myscaffold.mapper.UrlMapper;
import com.guany.myscaffold.service.PermService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限
 *
 * @Auther: guany
 * @Date: 2023/04/17
 */
@Service
public class PermServiceImpl implements PermService {

    @Resource
    private PermMapper permMapper;

    @Resource
    private PermUrlMapper permUrlMapper;

    @Resource
    private UrlMapper urlMapper;

    @Override
    public PageInfo<PermEntity> queryPermPageList(PermQueryDto permQueryDto) {
        PageHelper.startPage(permQueryDto.getPageNum(),permQueryDto.getPageNum());
        return new PageInfo<PermEntity>(permMapper.selectPerm(null,null,permQueryDto.getPermType()));
    }

    @Override
    public List<UrlEntity> queryPermUrls(String permId) {
        PermEntity permEntity = permMapper.selectByPrimaryKey(permId);
        if(permEntity == null){
            throw new CustomException("该权限不存在");
        }
        return permUrlMapper.selectUrlsByPermId(permId);
    }

    @Override
    public void updatePermUrls(String permId, List<String> urlList) {
        PermEntity permEntity = permMapper.selectByPrimaryKey(permId);
        if(permEntity == null){
            throw new CustomException("该权限不存在");
        }
        //删除旧数据，添加新数据
        permUrlMapper.deleteByPermId(permId);
        for(String urlId: urlList){
            if(urlMapper.selectByPrimaryKey(urlId) != null){
                permUrlMapper.insert(new PermUrlEntity(permId,urlId));
            }
        }
    }

    @Override
    public void addPerm(PermDto permDto) {
        if(!permMapper.selectPerm(permDto.getPermCode(),null,null).isEmpty()){
            throw new CustomException("权限代码已存在");
        }
        if(!permMapper.selectPerm(null,permDto.getPermName(),null).isEmpty()){
            throw new CustomException("权限名称已存在");
        }
        permMapper.insert(new PermEntity(permDto.getPermCode(), permDto.getPermType(), permDto.getPermName()));
    }

    @Override
    public void updatePerm(PermDto perm) {
        PermEntity permEntity = permMapper.selectByPrimaryKey(perm.getPermId());
        if(permEntity == null){
            throw new CustomException("该权限不存在");
        }
        permEntity.setPermCode(perm.getPermCode());
        permEntity.setPermName(perm.getPermName());
        permEntity.setPermType(perm.getPermType());
        permMapper.updateByPrimaryKey(permEntity);
    }

    @Override
    public void deletePerm(String permId) {
        PermEntity permEntity = permMapper.selectByPrimaryKey(permId);
        if(permEntity == null){
            throw new CustomException("该权限不存在");
        }
        permEntity.setDeleted(Constant.DELETED_TRUE_1);
        permMapper.updateByPrimaryKey(permEntity);

        //删除关联表
        permUrlMapper.deleteByPermId(permId);
    }
}
