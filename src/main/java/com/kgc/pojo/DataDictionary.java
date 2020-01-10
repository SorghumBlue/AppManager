package com.kgc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * data_dictionary
 * @author 
 */
public class DataDictionary implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 类型编码
     */
    private String typecode;

    /**
     * 类型名称
     */
    private String typename;

    /**
     * 类型值ID
     */
    private Long valueid;

    /**
     * 类型值Name
     */
    private String valuename;

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

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Long getValueid() {
        return valueid;
    }

    public void setValueid(Long valueid) {
        this.valueid = valueid;
    }

    public String getValuename() {
        return valuename;
    }

    public void setValuename(String valuename) {
        this.valuename = valuename;
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
        DataDictionary other = (DataDictionary) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTypecode() == null ? other.getTypecode() == null : this.getTypecode().equals(other.getTypecode()))
            && (this.getTypename() == null ? other.getTypename() == null : this.getTypename().equals(other.getTypename()))
            && (this.getValueid() == null ? other.getValueid() == null : this.getValueid().equals(other.getValueid()))
            && (this.getValuename() == null ? other.getValuename() == null : this.getValuename().equals(other.getValuename()))
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
        result = prime * result + ((getTypecode() == null) ? 0 : getTypecode().hashCode());
        result = prime * result + ((getTypename() == null) ? 0 : getTypename().hashCode());
        result = prime * result + ((getValueid() == null) ? 0 : getValueid().hashCode());
        result = prime * result + ((getValuename() == null) ? 0 : getValuename().hashCode());
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
        sb.append(", typecode=").append(typecode);
        sb.append(", typename=").append(typename);
        sb.append(", valueid=").append(valueid);
        sb.append(", valuename=").append(valuename);
        sb.append(", createdby=").append(createdby);
        sb.append(", creationdate=").append(creationdate);
        sb.append(", modifyby=").append(modifyby);
        sb.append(", modifydate=").append(modifydate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}