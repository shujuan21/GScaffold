package com.guany.myscaffold.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 用户dto
 *
 * @Auther: guany
 * @Date: 2023/04/24
 */
public class UserDto {

    public interface PrimaryKey{}
    public interface Create{}
    public interface Update{}
    public interface ResetPassword{}
    public interface Login{}

    /**
     * id
     */
    @NotBlank(message = "id不能为空",groups = {UserDto.PrimaryKey.class,UserDto.Update.class,UserDto.ResetPassword.class})
    private String id;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空",groups = {UserDto.Create.class,UserDto.Update.class,UserDto.Login.class})
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 密码
     */
    @Length(min = 6, message = "密码至少6位",groups = {UserDto.Create.class,UserDto.ResetPassword.class})
    @NotBlank(message = "密码不能为空",groups = {UserDto.Create.class,UserDto.ResetPassword.class})
    private String password;

    /**
     * 性别（1男、2女）
     */
//    @Enum(value={"1","2"},message="性别必须为1或2")
    private String sex;

    /**
     * 电话号码
     */
    @NotBlank(message = "电话不能为空",groups = {UserDto.Create.class,UserDto.Update.class})
    private String phoneNumber;

    /**
     * 地址
     */
    private String address;

    /**
     * 生日 YYYY-MM-dd
     */
    private String birthday;

    /**
     * 是否可用
     */
    private String enabled;

    /**
     * 是否未锁定
     */
    private String locked;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }
}