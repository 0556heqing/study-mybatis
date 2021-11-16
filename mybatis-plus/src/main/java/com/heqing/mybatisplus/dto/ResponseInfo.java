package com.heqing.mybatisplus.dto;

import java.io.Serializable;

/**
 * @author heqing
 * @date 2021/7/20 14:37
 */
public class ResponseInfo<T> implements Serializable {

    private int code;

    private String msg;

    private T data;

    public ResponseInfo(int code, String  msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseInfo buildSuccess(){
        return buildSuccess(null, null);
    }

    public static<T> ResponseInfo<T> buildSuccess(T data){
        return buildSuccess(RtnInfoCode.SUCCESS.getMsg(),data);
    }

    public static<T> ResponseInfo<T> buildSuccess(String msg, T data){
        if (isEmpty(msg)) {
            msg = RtnInfoCode.SUCCESS.getMsg();
        }
        return build(RtnInfoCode.SUCCESS.getCode(), msg, data);
    }

    public static ResponseInfo buildError(String errorMsg){
        if (isEmpty(errorMsg)) {
            errorMsg = RtnInfoCode.ERROR.getMsg();
        }
        return build(RtnInfoCode.ERROR.getCode(), errorMsg, null);
    }

    public static<T> ResponseInfo<T> build(RtnInfoCode reason, T data) {
        return build(reason.getCode(), reason.getMsg(), data);
    }

    public static<T> ResponseInfo<T> build(int code, String msg){
        return new ResponseInfo<T>(code, msg, null);
    }

    public static<T> ResponseInfo<T> build(int code, String msg, T data){
        return new ResponseInfo<T>(code, msg, data);
    }

    /**
     * 是否响应成功
     * @return
     */
    public boolean isSuccessful(){
        return code == RtnInfoCode.SUCCESS.getCode();
    }

    private  static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseInfo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
