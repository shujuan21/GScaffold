package com.guany.myscaffold.entity;

import com.guany.myscaffold.dto.UrlDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * url
 *
 * @Auther: guany
 * @Date: 2023/02/16
 */
@Entity
@Table(name = "t_url")
public class UrlEntity extends BaseEntity{

    /**
     * url
     */
    @NotBlank(message = "url不能为空")
    @Column(name = "url")
    private String url;

    /**
     * url描述
     */
    @NotBlank(message = "url描述不能为空")
    @Column(name = "descri")
    private String descri;

    public UrlEntity() {
    }

    public UrlEntity(UrlDto urlDto) {
        this.url = urlDto.getUrl();
        this.descri = urlDto.getDescri();
    }

    public UrlEntity(String url, String descri) {
        this.url = url;
        this.descri = descri;
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
