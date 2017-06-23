package com.uama.retrofit.converter.gson;

/**
 * Created by liwei on 2017/6/22 16:29
 * Email: liwei@uama.com.cn
 * Description: 接口返回数据实体类基类
 */

public class LMBaseBean {
    private String status;
    private String msg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
