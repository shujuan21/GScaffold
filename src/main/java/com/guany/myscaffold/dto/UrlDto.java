package com.guany.myscaffold.dto;

import javax.validation.constraints.NotBlank;

/**
 * url
 *
 * @Auther: guany
 * @Date: 2023/05/16
 */
public class UrlDto {

    public interface PrimaryKey{}
    public interface Create{}
    public interface Update{}

    /**
     * url id
     */
    @NotBlank(message = "url id不能为空",groups = {UrlDto.PrimaryKey.class,UrlDto.Update.class})
    private String urlId;

    /**
     * url
     */
    @NotBlank(message = "url不能为空",groups = {UrlDto.Create.class,UrlDto.Update.class})
    private String url;

    /**
     * url描述
     */
    @NotBlank(message = "url描述不能为空",groups = {UrlDto.Create.class,UrlDto.Update.class})
    private String descri;

    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }
}
