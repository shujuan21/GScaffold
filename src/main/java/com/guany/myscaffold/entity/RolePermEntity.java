package com.guany.myscaffold.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 角色-权限关联实体类
 *
 * @Auther: guany
 * @Date: 2023/02/16
 */
@Entity
@Table(name = "t_role_perm")
public class RolePermEntity extends BaseEntity{

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "perm_id")
    private String permId;

    public RolePermEntity() {
    }

    public RolePermEntity(String roleId, String permId) {
        this.roleId = roleId;
        this.permId = permId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId;
    }
}
