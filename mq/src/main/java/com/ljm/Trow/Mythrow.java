package com.ljm.Trow;

public class Mythrow extends Exception{


    private String msg;

    public Mythrow() {
    }

    public Mythrow(String message) {
        super(message);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }


}
