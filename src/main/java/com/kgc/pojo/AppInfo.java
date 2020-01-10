package com.kgc.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;

@Data
public class AppInfo {
    private Integer id;
    private String softwarename;
    private String apkname;
    private String supportrom;
    private String interfacelanguage;
    private String softwaresize;
    private Integer downloads;
    private Integer flatformid;
    private String appinfo;
    private Integer categorylevel1;
    private Integer categorylevel2;
    private Integer categorylevel3;
    private Integer status;
    private String logopicpath;
    private String logolocpath;
    @TableField(exist = false)
    private AppVersion appVersion;
}
