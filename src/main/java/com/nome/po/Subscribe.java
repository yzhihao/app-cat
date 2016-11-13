package com.nome.po;

public class Subscribe {
    private Integer id;

    private Integer userId;

    private Integer appId;

    private String lowrest;

    private String time;

    private Integer iscancel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getLowrest() {
        return lowrest;
    }

    public void setLowrest(String lowrest) {
        this.lowrest = lowrest == null ? null : lowrest.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getIscancel() {
        return iscancel;
    }

    public void setIscancel(Integer iscancel) {
        this.iscancel = iscancel;
    }
}