package com.guany.myscaffold.dto;

import javax.validation.constraints.NotBlank;

/**
 * @Auther: guany
 * @Date: 2023/07/04
 */
public class RoleDto {

    public interface PrimaryKey{}
    public interface Update{}
    public interface Create{}


    /**
     * 角色id
     */
    @NotBlank(message = "角色id不能为空",groups = {RoleDto.PrimaryKey.class,RoleDto.Update.class})
    private String roleId;

    /**
     * 角色代码
     */
    @NotBlank(message = "角色代码不能为空",groups = {RoleDto.Create.class,RoleDto.Update.class})
    private String roleCode;

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不能为空",groups = {RoleDto.Create.class,RoleDto.Update.class})
    private String roleName;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
