package com.cninter.andorid5;

/**
 * Created by ${jacksen-hss} on 2016/7/14 0014.
 */
public class RecycleViewitem {
    private int resid;
    private String msg;

    public RecycleViewitem() {
    }

    public RecycleViewitem(int resid, String msg) {
        this.resid = resid;
        this.msg = msg;
    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
