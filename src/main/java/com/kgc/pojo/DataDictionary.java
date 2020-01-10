package com.kgc.pojo;

import java.util.Date;

@lombok.Data
public class DataDictionary {
    private Integer id;
    private String typecode;
    private String typename;
    private Integer valueid;
    private String valuename;
    private Integer createdby;
    private Date creationdate;

}
