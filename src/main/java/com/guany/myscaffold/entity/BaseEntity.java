package com.guany.myscaffold.entity;

import com.guany.myscaffold.common.UUIdGenId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: guany
 * @Date: 2023/04/27
 */
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @Column(name = "ID")
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @CreatedDate
    @Column(name = "GMTCREATE")
    private Date gmtCreate;

    @CreatedBy
    @Column(name = "NAMECREATE")
    private String nameCreate;

    @LastModifiedDate
    @Column(name = "GMTMODIFIED")
    private Date gmtModified;

    @LastModifiedBy
    @Column(name = "NAMEMODIFIED")
    private String nameModified;

    @Column(name = "DELETED")
    private Integer deleted = 0;

    public BaseEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getNameCreate() {
        return nameCreate;
    }

    public void setNameCreate(String nameCreate) {
        this.nameCreate = nameCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getNameModified() {
        return nameModified;
    }

    public void setNameModified(String nameModified) {
        this.nameModified = nameModified;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

