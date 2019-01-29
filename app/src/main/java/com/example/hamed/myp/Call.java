package com.example.hamed.myp;

public class Call {
    private String callerName,callTime;
    private  int myImg;
    public Call(String callerName, String callTime, int myImg) {
        this.callerName = callerName;
        this.callTime = callTime;
        this.myImg=myImg;
    }

    public String getCallerName() {
        return callerName;
    }

    public String getCallTime() {
        return callTime;
    }public int getMyImage() {
        return myImg;
    }
}

