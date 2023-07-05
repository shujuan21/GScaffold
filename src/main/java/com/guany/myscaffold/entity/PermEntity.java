package com.guany.myscaffold.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * 权限
 *
 * @Auther: guany
 * @Date: 2023/02/16
 */
@Entity
@Table(name = "t_perm")
public class PermEntity extends BaseEntity implements GrantedAuthority {

    /**
     * 权限代码
     */
    @NotBlank(message = "权限代码不能为空")
    @Column(name = "perm_code")
    private String permCode;

    /**
     * 权限类型
     */
    @NotBlank(message = "权限类型不能为空")
    @Column(name = "perm_type")
    private String permType;

    /**
     * 权限名称
     */
    @NotBlank(message = "权限名称不能为空")
    @Column(name = "perm_name")
    private String permName;

    public PermEntity() {
    }

    public PermEntity(String permCode, String permType, String permName) {
        this.permCode = permCode;
        this.permType = permType;
        this.permName = permName;
    }

    public String getPermCode() {
        return permCode;
    }

    public void setPermCode(String permCode) {
        this.permCode = permCode;
    }

    public String getPermType() {
        return permType;
    }

    public void setPermType(String permType) {
        this.permType = permType;
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    @Override
    public String getAuthority() {
        return permName;
    }
}
