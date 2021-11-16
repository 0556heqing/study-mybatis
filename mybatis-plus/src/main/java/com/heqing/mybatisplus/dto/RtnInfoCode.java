package com.heqing.mybatisplus.dto;

/**
 * @author heqing
 * @date 2021/7/20 14:40
 */
public enum RtnInfoCode {

    //接口访问成功
    SUCCESS(0, "请求成功"),
    //接口内部错误
    ERROR(-1, "接口繁忙");

    private int code;
    private String msg;

    RtnInfoCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static RtnInfoCode getByCode(int code){
        for (RtnInfoCode temp : RtnInfoCode.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return ERROR;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
