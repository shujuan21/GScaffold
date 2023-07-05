package com.guany.myscaffold.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 用户-角色关联dto
 *
 * @Auther: guany
 * @Date: 2023/04/24
 */
public class UserRoleDto {

    @NotBlank(message = "用户id不能为空")
    private String userId;

    @NotEmpty(message = "用户角色不能为空")
    private List<String> roleList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }
}
