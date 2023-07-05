package com.guany.myscaffold.api;

import com.guany.myscaffold.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统api
 *
 * @Auther: guany
 * @Date: 2023/04/11
 */
@RestController
@RequestMapping("/api")
public class SystemApi {

    @GetMapping("/test")
    public Result test(){
        return Result.success();
    }
}
