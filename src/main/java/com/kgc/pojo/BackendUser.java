package com.kgc.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;

import java.util.Date;
@Data
public class BackendUser {
    @TableField(exist = false)
    private final String typeCode = "USER_TYPE";
    private Integer id;
    private String usercode;
    private String username;
    private Date creationdate;
    private String userpassword;
    private Integer modifyby;
    private Date modifydate;
    private Integer createdby;
    private Long usertype;
    @TableField(exist = false)
    private String userTypeName;
}
