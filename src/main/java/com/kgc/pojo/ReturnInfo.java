package com.kgc.pojo;

import lombok.Data;

@Data
public class ReturnInfo {
    private String delResult;        // 删除结果
    private String errorCode;        // 上架下架错误码
    private String resultMsg;        // 上架下架信息
}
