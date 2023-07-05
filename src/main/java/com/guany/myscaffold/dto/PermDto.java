package com.guany.myscaffold.dto;

import javax.validation.constraints.NotBlank;

/**
 * @Auther: guany
 * @Date: 2023/07/04
 */
public class PermDto {

    public interface PrimaryKey{}
    public interface Create{}
    public interface Update{}

    /**
     * 权限id
     */
    @NotBlank(message = "权限id不能为空",groups = {PermDto.PrimaryKey.class,PermDto.Update.class})
    private String permId;

    /**
     * 权限代码
     */
    @NotBlank(message = "权限代码不能为空",groups = {PermDto.Create.class,PermDto.Update.class})
    private String permCode;

    /**
     * 权限类型
     */
    @NotBlank(message = "权限类型不能为空",groups = {PermDto.Create.class,PermDto.Update.class})
    private String permType;

    /**
     * 权限名称
     */
    @NotBlank(message = "权限名称不能为空")
    private String permName;

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId;
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
}
