package com.kgc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * app_category
 * @author 
 */
public class AppCategory implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 分类编码
     */
    private String categorycode;

    /**
     * 分类名称
     */
    private String categoryname;

    /**
     * 父级节点id
     */
    private Long parentid;

    /**
     * 创建者（来源于backend_user用户表的用户id）
     */
    private Long createdby;

    /**
     * 创建时间
     */
    private Date creationtime;

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

    public String getCategorycode() {
        return categorycode;
    }

    public void setCategorycode(String categorycode) {
        this.categorycode = categorycode;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
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
        AppCategory other = (AppCategory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCategorycode() == null ? other.getCategorycode() == null : this.getCategorycode().equals(other.getCategorycode()))
            && (this.getCategoryname() == null ? other.getCategoryname() == null : this.getCategoryname().equals(other.getCategoryname()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getCreatedby() == null ? other.getCreatedby() == null : this.getCreatedby().equals(other.getCreatedby()))
            && (this.getCreationtime() == null ? other.getCreationtime() == null : this.getCreationtime().equals(other.getCreationtime()))
            && (this.getModifyby() == null ? other.getModifyby() == null : this.getModifyby().equals(other.getModifyby()))
            && (this.getModifydate() == null ? other.getModifydate() == null : this.getModifydate().equals(other.getModifydate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCategorycode() == null) ? 0 : getCategorycode().hashCode());
        result = prime * result + ((getCategoryname() == null) ? 0 : getCategoryname().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getCreatedby() == null) ? 0 : getCreatedby().hashCode());
        result = prime * result + ((getCreationtime() == null) ? 0 : getCreationtime().hashCode());
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
        sb.append(", categorycode=").append(categorycode);
        sb.append(", categoryname=").append(categoryname);
        sb.append(", parentid=").append(parentid);
        sb.append(", createdby=").append(createdby);
        sb.append(", creationtime=").append(creationtime);
        sb.append(", modifyby=").append(modifyby);
        sb.append(", modifydate=").append(modifydate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}