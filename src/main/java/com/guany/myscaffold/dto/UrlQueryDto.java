package com.guany.myscaffold.dto;

/**
 * url查询dto
 *
 * @Auther: guany
 * @Date: 2023/05/16
 */
public class UrlQueryDto {
    /**
     * 当前页码
     */
    private Integer pageNum = 1;

    /**
     * 每页行数
     */
    private Integer pageSize = 10;

    /**
     * url
     */
    private String url;

    public UrlQueryDto() {
    }

    public UrlQueryDto(Integer pageNum, Integer pageSize, String url) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
