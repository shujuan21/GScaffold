package com.guany.myscaffold.dto;

/**
 * 用户查询dto
 *
 * @Auther: guany
 * @Date: 2023/04/24
 */
public class UserQueryDto {

    /**
     * 当前页码
     */
    private Integer pageNum = 1;

    /**
     * 每页行数
     */
    private Integer pageSize = 10;

    /**
     * 用户名
     */
    private String username;

    /**
     * 是否可用
     */
    private String enabled;

    /**
     * 是否未锁定
     */
    private String locked;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
