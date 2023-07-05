package com.guany.myscaffold.api;

import com.guany.myscaffold.common.result.Result;
import com.guany.myscaffold.dto.RoleDto;
import com.guany.myscaffold.dto.RolePermsDto;
import com.guany.myscaffold.service.RoleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 角色api
 *
 * @Auther: guany
 * @Date: 2023/04/17
 */
@RequestMapping(value = "/api/role")
@RestController
public class RoleApi {

    @Resource
    private RoleService roleService;

    /**
     * 查询角色列表
     *
     * @return 所有角色信息
     */
    @PostMapping(value = "/queryRoleList")
    public Object queryRoleList(){
        return Result.success(roleService.queryRoleList());
    }

    /**
     * 查询角色关联权限
     *
     * @return 角色关联的权限
     */
    @PostMapping(value = "/queryRolePerms")
    public Object queryRolePerms(@Validated(RoleDto.PrimaryKey.class) @RequestBody RoleDto role){
        return Result.success(roleService.queryRolePerms(role.getRoleId()));
    }

    /**
     * 更新角色关联权限
     *
     * @return null
     */
    @PostMapping(value = "/updateRolePerms")
    public Object updateRolePerms(@Valid @RequestBody RolePermsDto rolePermsDto){
        roleService.updateRolePerms(rolePermsDto.getRoleId(),rolePermsDto.getPermList());
        return Result.success();
    }

    /**
     * 新增角色
     *
     * @param roleDto 角色信息
     * @return null
     */
    @PostMapping(value = "/addRole")
    public Object addRole(@Validated(RoleDto.Create.class) @RequestBody RoleDto roleDto){
        roleService.addRole(roleDto);
        return Result.success();
    }

    /**
     * 删除角色
     *
     * @param role 角色信息
     * @return null
     */
    @PostMapping(value = "/deleteRole")
    public Object deleteRole(@Validated(RoleDto.PrimaryKey.class) @RequestBody RoleDto role){
        roleService.deleteRole(role.getRoleId());
        return Result.success();
    }

    /**
     * 编辑角色
     *
     * @param roleDto 角色信息
     * @return null
     */
    @PostMapping(value = "/updateRole")
    public Object updateRole(@Validated(RoleDto.Update.class) @RequestBody RoleDto roleDto){
        roleService.updateRole(roleDto);
        return Result.success();
    }

}
