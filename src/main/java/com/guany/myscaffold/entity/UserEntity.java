package com.guany.myscaffold.entity;

import com.guany.myscaffold.common.valid.Enum;
import com.guany.myscaffold.dto.UserDto;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * 用户entity
 *
 * @Auther: guany
 * @Date: 2023/04/17
 */
@Entity
@Table(name = "t_user")
public class UserEntity extends BaseEntity {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    @Column(name = "username")
    private String username;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 密码
     */
    @Length(min = 6,message = "密码至少6位")
    @NotBlank(message = "密码不能为空")
    @Column(name = "password")
    private String password;

    /**
     * 性别（1男、2女）
     */
    @Enum(value={"1","2"},message="性别必须为1或2")
    @Column(name = "sex")
    private String sex;

    /**
     * 电话号码
     */
    @NotBlank(message = "电话不能为空")
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 生日 YYYY-MM-dd
     */
    @Column(name = "birthday")
    private String birthday;

    /**
     * 是否可用
     */
    @Column(name = "enabled")
    private String enabled;

    /**
     * 是否未锁定
     */
    @Column(name = "locked")
    private String locked;

    public UserEntity(UserDto userDto){
        this.username = userDto.getUsername();
        this.realName = userDto.getRealName();
        this.password = userDto.getPassword();
        this.sex = userDto.getSex();
        this.phoneNumber = userDto.getPhoneNumber();
        this.address = userDto.getAddress();
        this.birthday = userDto.getBirthday();
        this.enabled = userDto.getEnabled();
        this.locked = userDto.getLocked();
    }

    public UserEntity() {
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

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

}
