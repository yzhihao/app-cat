package com.nome.po;

public class Subscribe {
    private Integer id;

    private Integer userId;

    private Integer appId;

    private String lowrest;

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

	@Override
	public String toString() {
		return "Subscribe [id=" + id + ", userId=" + userId + ", appId=" + appId + ", lowrest=" + lowrest + "]";
	}
    
    
}