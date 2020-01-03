package com.kgc.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class BackendUser {
    private Integer id;
    private String usercode;
    private String username;
    private Date creationdate;
    private String userpassword;
    private Integer modifyby;
    private Date modifydate;
    private Integer createdby;
    private Integer usertype;
}
