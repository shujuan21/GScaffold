package com.guany.myscaffold.api;

import com.guany.myscaffold.common.result.Result;
import com.guany.myscaffold.dto.PermDto;
import com.guany.myscaffold.dto.PermQueryDto;
import com.guany.myscaffold.dto.PermUrlsDto;
import com.guany.myscaffold.service.PermService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 权限api
 *
 * @Auther: guany
 * @Date: 2023/04/17
 */
@RequestMapping(value = "/api/perm")
@RestController
public class PermApi {

    @Resource
    private PermService permService;

    /**
     * 查询所有权限
     *
     * @return 权限列表
     */
    @PostMapping(value = "/queryPermList")
    public Object queryPermPageList(@RequestBody PermQueryDto permQueryDto){
        return Result.success(permService.queryPermPageList(permQueryDto));
    }

    /**
     * 查询权限关联url
     *
     * @return url列表
     */
    @PostMapping(value = "/queryPermUrls")
    public Object queryPermUrls(@Validated(PermDto.PrimaryKey.class) @RequestBody PermDto permDto){
        return Result.success(permService.queryPermUrls(permDto.getPermId()));
    }

    /**
     * 更新权限关联url
     *
     * @return null
     */
    @PostMapping(value = "/updatePermUrls")
    public Object updatePermUrls(@Valid @RequestBody PermUrlsDto permUrlsDto){
        permService.updatePermUrls(permUrlsDto.getPermId(),permUrlsDto.getUrlList());
        return Result.success();
    }

    /**
     * 新增权限
     *
     * @return null
     */
    @PostMapping(value = "/addPerm")
    public Object addPerm(@Valid @RequestBody PermDto permDto){
        permService.addPerm(permDto);
        return Result.success();
    }

    /**
     * 编辑权限
     *
     * @return null
     */
    @PostMapping(value = "/updatePerm")
    public Object updatePerm(@Validated(PermDto.Update.class) @RequestBody PermDto permDto){
        permService.updatePerm(permDto);
        return Result.success();
    }

    /**
     * 删除权限
     *
     * @return null
     */
    @PostMapping(value = "/deletePerm")
    public Object deletePerm(@Validated(PermDto.PrimaryKey.class) @RequestBody PermDto permDto){
        permService.deletePerm(permDto.getPermId());
        return Result.success();
    }
}
