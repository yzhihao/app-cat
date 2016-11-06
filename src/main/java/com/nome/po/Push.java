package com.nome.po;

public class Push {
    private Integer id;

    private Integer userId;

    private Integer appId;

    private String lowestPrice;

    private String curPrice;

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

    public String getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(String lowestPrice) {
        this.lowestPrice = lowestPrice == null ? null : lowestPrice.trim();
    }

    public String getCurPrice() {
        return curPrice;
    }

    public void setCurPrice(String curPrice) {
        this.curPrice = curPrice == null ? null : curPrice.trim();
    }

	@Override
	public String toString() {
		return "Push [id=" + id + ", userId=" + userId + ", appId=" + appId + ", lowestPrice=" + lowestPrice
				+ ", curPrice=" + curPrice + "]";
	}
    
    
}