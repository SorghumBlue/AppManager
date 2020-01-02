package com.kgc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * dev_user
 * @author 
 */
public class DevUser implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 开发者帐号
     */
    private String devcode;

    /**
     * 开发者名称
     */
    private String devname;

    /**
     * 开发者密码
     */
    private String devpassword;

    /**
     * 开发者电子邮箱
     */
    private String devemail;

    /**
     * 开发者简介
     */
    private String devinfo;

    /**
     * 创建者（来源于backend_user用户表的用户id）
     */
    private Long createdby;

    /**
     * 创建时间
     */
    private Date creationdate;

    /**
     * 更新者（来源于backend_user用户表的用户id）
     */
    private Long modifyby;

    /**
     * 最新更新时间
     */
    private Date modifydate;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDevcode() {
        return devcode;
    }

    public void setDevcode(String devcode) {
        this.devcode = devcode;
    }

    public String getDevname() {
        return devname;
    }

    public void setDevname(String devname) {
        this.devname = devname;
    }

    public String getDevpassword() {
        return devpassword;
    }

    public void setDevpassword(String devpassword) {
        this.devpassword = devpassword;
    }

    public String getDevemail() {
        return devemail;
    }

    public void setDevemail(String devemail) {
        this.devemail = devemail;
    }

    public String getDevinfo() {
        return devinfo;
    }

    public void setDevinfo(String devinfo) {
        this.devinfo = devinfo;
    }

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Long getModifyby() {
        return modifyby;
    }

    public void setModifyby(Long modifyby) {
        this.modifyby = modifyby;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        DevUser other = (DevUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDevcode() == null ? other.getDevcode() == null : this.getDevcode().equals(other.getDevcode()))
            && (this.getDevname() == null ? other.getDevname() == null : this.getDevname().equals(other.getDevname()))
            && (this.getDevpassword() == null ? other.getDevpassword() == null : this.getDevpassword().equals(other.getDevpassword()))
            && (this.getDevemail() == null ? other.getDevemail() == null : this.getDevemail().equals(other.getDevemail()))
            && (this.getDevinfo() == null ? other.getDevinfo() == null : this.getDevinfo().equals(other.getDevinfo()))
            && (this.getCreatedby() == null ? other.getCreatedby() == null : this.getCreatedby().equals(other.getCreatedby()))
            && (this.getCreationdate() == null ? other.getCreationdate() == null : this.getCreationdate().equals(other.getCreationdate()))
            && (this.getModifyby() == null ? other.getModifyby() == null : this.getModifyby().equals(other.getModifyby()))
            && (this.getModifydate() == null ? other.getModifydate() == null : this.getModifydate().equals(other.getModifydate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDevcode() == null) ? 0 : getDevcode().hashCode());
        result = prime * result + ((getDevname() == null) ? 0 : getDevname().hashCode());
        result = prime * result + ((getDevpassword() == null) ? 0 : getDevpassword().hashCode());
        result = prime * result + ((getDevemail() == null) ? 0 : getDevemail().hashCode());
        result = prime * result + ((getDevinfo() == null) ? 0 : getDevinfo().hashCode());
        result = prime * result + ((getCreatedby() == null) ? 0 : getCreatedby().hashCode());
        result = prime * result + ((getCreationdate() == null) ? 0 : getCreationdate().hashCode());
        result = prime * result + ((getModifyby() == null) ? 0 : getModifyby().hashCode());
        result = prime * result + ((getModifydate() == null) ? 0 : getModifydate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", devcode=").append(devcode);
        sb.append(", devname=").append(devname);
        sb.append(", devpassword=").append(devpassword);
        sb.append(", devemail=").append(devemail);
        sb.append(", devinfo=").append(devinfo);
        sb.append(", createdby=").append(createdby);
        sb.append(", creationdate=").append(creationdate);
        sb.append(", modifyby=").append(modifyby);
        sb.append(", modifydate=").append(modifydate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}