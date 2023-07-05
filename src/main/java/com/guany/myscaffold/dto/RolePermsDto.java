package com.guany.myscaffold.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 角色权限关联dto
 *
 * @Auther: guany
 * @Date: 2023/05/15
 */
public class RolePermsDto {

    @NotBlank(message = "角色id不能为空")
    private String roleId;

    @NotEmpty(message = "权限不能为空")
    private List<String> permList;

    public RolePermsDto() {
    }

    public RolePermsDto(String roleId, List<String> permList) {
        this.roleId = roleId;
        this.permList = permList;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<String> getPermList() {
        return permList;
    }

    public void setPermList(List<String> permList) {
        this.permList = permList;
    }
}
