package com.guany.myscaffold.api;

import com.guany.myscaffold.common.result.Result;
import com.guany.myscaffold.dto.UrlDto;
import com.guany.myscaffold.dto.UrlQueryDto;
import com.guany.myscaffold.service.UrlService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * url
 *
 * @Auther: guany
 * @Date: 2023/04/17
 */
@RestController
@RequestMapping("/api/url")
public class UrlApi {

    @Resource
    private UrlService urlService;

    /**
     * 查询url(分页)
     *
     * @param urlQueryDto url查询dto
     * @return
     */
    @PostMapping(value = "/queryUrls")
    public Object queryUrlPageList(@RequestBody UrlQueryDto urlQueryDto){
        return Result.success(urlService.queryUrlPageList(urlQueryDto));
    }

    /**
     * 新增url
     * @param urlDto url信息
     * @return null
     */
    @PostMapping(value = "/createUrl")
    public Object createUrl(@Validated(UrlDto.Create.class) @RequestBody UrlDto urlDto){
        urlService.createUrl(urlDto);
        return Result.success();
    }

    /**
     * 编辑url
     * @param urlDto url信息
     * @return null
     */
    @PostMapping(value = "/updateUrl")
    public Object updateUrl(@Validated(UrlDto.Update.class) @RequestBody UrlDto urlDto){
        urlService.updateUrl(urlDto);
        return Result.success();
    }

    /**
     * 删除url
     *
     * @param urlDto url信息
     * @return null
     */
    @PostMapping(value = "/deleteUrl")
    public Object deleteUrl(@Validated(UrlDto.PrimaryKey.class) @RequestBody UrlDto urlDto){
        urlService.deleteUrl(urlDto.getUrlId());
        return Result.success();
    }

}
