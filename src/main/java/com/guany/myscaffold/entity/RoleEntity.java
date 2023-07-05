package com.guany.myscaffold.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * 角色
 *
 * @Auther: guany
 * @Date: 2023/02/16
 */
@Entity
@Table(name = "t_role")
public class RoleEntity extends BaseEntity implements GrantedAuthority {

    /**
     * 角色代码
     */
    @NotBlank(message = "角色代码不能为空")
    @Column(name = "role_code")
    private String roleCode;

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不能为空")
    @Column(name = "role_name")
    private String roleName;

    public RoleEntity() {
    }

    public RoleEntity(String roleCode, String roleName) {
        this.roleCode = roleCode;
        this.roleName = roleName;
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

    @Override
    public String getAuthority() {
        return roleName;
    }

}
