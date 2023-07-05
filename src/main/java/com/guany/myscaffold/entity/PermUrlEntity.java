package com.guany.myscaffold.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *权限-url关联实体类
 *
 * @Auther: guany
 * @Date: 2023/02/16
 */
@Entity
@Table(name = "t_perm_url")
public class PermUrlEntity extends BaseEntity{

    @Column(name = "perm_id")
    private String permId;

    @Column(name = "url_id")
    private String urlId;

    public PermUrlEntity() {
    }

    public PermUrlEntity(String permId, String urlId) {
        this.permId = permId;
        this.urlId = urlId;
    }

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId;
    }

    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId;
    }
}
