package com.guany.myscaffold.dto;

/**
 * 权限查询dto
 *
 * @Auther: guany
 * @Date: 2023/05/16
 */
public class PermQueryDto {
    /**
     * 当前页码
     */
    private Integer pageNum = 1;

    /**
     * 每页行数
     */
    private Integer pageSize = 10;

    /**
     * 权限类型
     */
    private String permType;

    public PermQueryDto() {
    }

    public PermQueryDto(Integer pageNum, Integer pageSize, String permType) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.permType = permType;
    }

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

    public String getPermType() {
        return permType;
    }

    public void setPermType(String permType) {
        this.permType = permType;
    }
}