package com.guany.myscaffold.api;

import com.guany.myscaffold.common.result.Result;
import com.guany.myscaffold.dto.UserDto;
import com.guany.myscaffold.dto.UserQueryDto;
import com.guany.myscaffold.dto.UserRoleDto;
import com.guany.myscaffold.security.SecurityUtil;
import com.guany.myscaffold.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 用户api
 *
 * @Auther: guany
 * @Date: 2023/04/17
 */
@RestController
@RequestMapping("/api/user")
public class UserApi {

    @Resource
    private UserService userService;

    @Resource
    AuthenticationManager authenticationManager;

    /**
     * 查询用户列表
     * @param userQueryDto 查询条件
     * @return 用户列表
     */
    @PostMapping(value = "/queryUserList")
    public Object queryUserList(@RequestBody UserQueryDto userQueryDto){
        return Result.success(userService.queryUserList(userQueryDto));
    }

    /**
     * 分页查询用户信息
     * @param userQueryDto 查询条件
     * @return 用户分页列表
     */
    @PostMapping(value = "/queryUserPageList")
    public Object queryUserPageList(@RequestBody UserQueryDto userQueryDto){
        return Result.success(userService.queryUserPageList(userQueryDto));
    }

    /**
     * 查询当前用户对应的角色
     * @param user 当前用户
     * @return 角色列表
     * @throws Exception
     */
    @PostMapping(value = "/queryUserRoles")
    public Object queryUserRoles(@Validated(UserDto.PrimaryKey.class) @RequestBody UserDto user) {
        return Result.success(userService.queryUserRoles(user.getId()));
    }

    /**
     * 注册用户
     * @param user 用户信息
     */
    @PostMapping(value = "/signUp")
    public Object signUp(@Validated(UserDto.Create.class) @RequestBody UserDto user){
        userService.createUser(user);
        return Result.success();
    }

    /**
     * 删除用户
     * @param user 当前用户
     */
    @PostMapping(value = "/deleteUser")
    public Object deleteUser(@Validated(UserDto.PrimaryKey.class) @RequestBody UserDto user){
        userService.deleteUser(user.getId());
        return Result.success();
    }

    /**
     *编辑用户信息
     * @param user 当前用户
     */
    @PostMapping(value = "/updateUser")
    public Object updateUser(@Validated(UserDto.Update.class) @RequestBody UserDto user){
        userService.updateUser(user);
        return Result.success();
    }

    /**
     * 锁定用户
     * @param user 当前用户
     */
    @PostMapping(value = "/lockUser")
    public Object lockUser(@Validated(UserDto.PrimaryKey.class) @RequestBody UserDto user){
        userService.lockUser(user.getId());
        return Result.success();
    }

    /**
     * 解锁用户
     * @param user 当前用户
     */
    @PostMapping(value = "/unlockUser")
    public Object unlockUser(@Validated(UserDto.PrimaryKey.class) @RequestBody UserDto user){
        userService.unlockUser(user.getId());
        return Result.success();
    }

    /**
     * 启用用户
     * @param user 当前用户
     */
    @PostMapping(value = "/enableUser")
    public Object enableUser(@Validated(UserDto.PrimaryKey.class) @RequestBody UserDto user){
        userService.enableUser(user.getId());
        return Result.success();
    }

    /**
     * 停用用户
     * @param user 当前用户
     */
    @PostMapping(value = "/disableUser")
    public Object disableUser(@Validated(UserDto.PrimaryKey.class) @RequestBody UserDto user){
        userService.disableUser(user.getId());
        return Result.success();
    }

    /**
     * 重置用户密码
     * @param userdto 当前用户
     */
    @PostMapping(value = "/resetPassword")
    public Object resetPassword(@Validated(UserDto.ResetPassword.class) @RequestBody UserDto userdto){
        userService.resetPassword(userdto);
        return Result.success();
    }

    /**
     * 更新用户角色信息
     * @param userRoleDto 用户更新的角色
     * @throws Exception
     */
    @PostMapping(value = "/updateUserRoles")
    public Object updateUserRoles(@Valid @RequestBody UserRoleDto userRoleDto) throws Exception {
        userService.updateUserRole(userRoleDto.getUserId(),userRoleDto.getRoleList());
        return Result.success();
    }

    /**
     * 用户登录
     * @param userDto 用户信息
     * @return UserDto
     */
    @PostMapping(value = "/login")
    public Object login(@Validated({UserDto.Login.class}) @RequestBody UserDto userDto ){
        return Result.success(SecurityUtil.login(userDto.getUsername(),userDto.getPassword(),authenticationManager));
    }

    /**
     * 用户登出
     * @param
     */
    @PostMapping(value = "/logout")
    public Object logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {//获取授权对象，然后清除认证
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return Result.success();
    }

    /**
     * 获取当前用户
     * @return UserInfo
     */
    @PostMapping(value = "/queryCurrentUserInfo")
    public Object queryCurrentUserInfo(){
        return Result.success(SecurityUtil.getUserInfo());
    }
}
