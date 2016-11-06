package com.nome.po;

public class AppHistoryInfo {
    private Integer id;

    private String price;

    private String time;

    private Integer appId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

	@Override
	public String toString() {
		return "AppHistoryInfo [id=" + id + ", price=" + price + ", time=" + time + ", appId=" + appId + "]";
	}
    
    
}