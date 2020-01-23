package com.kgc.pojo;

import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * app_version
 * @author 
 */
public class AppVersion implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * appId（来源于：app_info表的主键id）
     */
    private Long appid;

    /**
     * 版本号
     */
    private String versionno;

    /**
     * 版本介绍
     */
    private String versioninfo;

    /**
     * 发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）
     */
    private Long publishstatus;

    /**
     * 下载链接
     */
    private String downloadlink;

    /**
     * 版本大小（单位：M）
     */
    private BigDecimal versionsize;

    /**
     * 创建者（来源于dev_user开发者信息表的用户id）
     */
    private Long createdby;

    /**
     * 创建时间
     */
    private Date creationdate;

    /**
     * 更新者（来源于dev_user开发者信息表的用户id）
     */
    private Long modifyby;

    /**
     * 最新更新时间
     */
    private Date modifydate;

    /**
     * apk文件的服务器存储路径
     */
    private String apklocpath;

    /**
     * 上传的apk文件名称
     */
    private String apkfilename;

    @TableField(exist = false)
    private String appname;
    @TableField(exist = false)
    private String publishstatusname;

    public String getPublishstatusname() {
        return publishstatusname;
    }

    public void setPublishstatusname(String publishstatusname) {
        this.publishstatusname = publishstatusname;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppid() {
        return appid;
    }

    public void setAppid(Long appid) {
        this.appid = appid;
    }

    public String getVersionno() {
        return versionno;
    }

    public void setVersionno(String versionno) {
        this.versionno = versionno;
    }

    public String getVersioninfo() {
        return versioninfo;
    }

    public void setVersioninfo(String versioninfo) {
        this.versioninfo = versioninfo;
    }

    public Long getPublishstatus() {
        return publishstatus;
    }

    public void setPublishstatus(Long publishstatus) {
        this.publishstatus = publishstatus;
    }

    public String getDownloadlink() {
        return downloadlink;
    }

    public void setDownloadlink(String downloadlink) {
        this.downloadlink = downloadlink;
    }

    public BigDecimal getVersionsize() {
        return versionsize;
    }

    public void setVersionsize(BigDecimal versionsize) {
        this.versionsize = versionsize;
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

    public String getApklocpath() {
        return apklocpath;
    }

    public void setApklocpath(String apklocpath) {
        this.apklocpath = apklocpath;
    }

    public String getApkfilename() {
        return apkfilename;
    }

    public void setApkfilename(String apkfilename) {
        this.apkfilename = apkfilename;
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
        AppVersion other = (AppVersion) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppid() == null ? other.getAppid() == null : this.getAppid().equals(other.getAppid()))
            && (this.getVersionno() == null ? other.getVersionno() == null : this.getVersionno().equals(other.getVersionno()))
            && (this.getVersioninfo() == null ? other.getVersioninfo() == null : this.getVersioninfo().equals(other.getVersioninfo()))
            && (this.getPublishstatus() == null ? other.getPublishstatus() == null : this.getPublishstatus().equals(other.getPublishstatus()))
            && (this.getDownloadlink() == null ? other.getDownloadlink() == null : this.getDownloadlink().equals(other.getDownloadlink()))
            && (this.getVersionsize() == null ? other.getVersionsize() == null : this.getVersionsize().equals(other.getVersionsize()))
            && (this.getCreatedby() == null ? other.getCreatedby() == null : this.getCreatedby().equals(other.getCreatedby()))
            && (this.getCreationdate() == null ? other.getCreationdate() == null : this.getCreationdate().equals(other.getCreationdate()))
            && (this.getModifyby() == null ? other.getModifyby() == null : this.getModifyby().equals(other.getModifyby()))
            && (this.getModifydate() == null ? other.getModifydate() == null : this.getModifydate().equals(other.getModifydate()))
            && (this.getApklocpath() == null ? other.getApklocpath() == null : this.getApklocpath().equals(other.getApklocpath()))
            && (this.getApkfilename() == null ? other.getApkfilename() == null : this.getApkfilename().equals(other.getApkfilename()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppid() == null) ? 0 : getAppid().hashCode());
        result = prime * result + ((getVersionno() == null) ? 0 : getVersionno().hashCode());
        result = prime * result + ((getVersioninfo() == null) ? 0 : getVersioninfo().hashCode());
        result = prime * result + ((getPublishstatus() == null) ? 0 : getPublishstatus().hashCode());
        result = prime * result + ((getDownloadlink() == null) ? 0 : getDownloadlink().hashCode());
        result = prime * result + ((getVersionsize() == null) ? 0 : getVersionsize().hashCode());
        result = prime * result + ((getCreatedby() == null) ? 0 : getCreatedby().hashCode());
        result = prime * result + ((getCreationdate() == null) ? 0 : getCreationdate().hashCode());
        result = prime * result + ((getModifyby() == null) ? 0 : getModifyby().hashCode());
        result = prime * result + ((getModifydate() == null) ? 0 : getModifydate().hashCode());
        result = prime * result + ((getApklocpath() == null) ? 0 : getApklocpath().hashCode());
        result = prime * result + ((getApkfilename() == null) ? 0 : getApkfilename().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appid=").append(appid);
        sb.append(", versionno=").append(versionno);
        sb.append(", versioninfo=").append(versioninfo);
        sb.append(", publishstatus=").append(publishstatus);
        sb.append(", downloadlink=").append(downloadlink);
        sb.append(", versionsize=").append(versionsize);
        sb.append(", createdby=").append(createdby);
        sb.append(", creationdate=").append(creationdate);
        sb.append(", modifyby=").append(modifyby);
        sb.append(", modifydate=").append(modifydate);
        sb.append(", apklocpath=").append(apklocpath);
        sb.append(", apkfilename=").append(apkfilename);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}