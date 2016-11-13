package com.nome.po;

public class Comment {
    private Integer id;

    private Integer appId;

    private Integer userId;

    private String time;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getContend() {
        return content;
    }

    public void setContend(String contend) {
        this.content = contend == null ? null : contend.trim();
    }

	@Override
	public String toString() {
		return "Comment [id=" + id + ", appId=" + appId + ", userId=" + userId + ", time=" + time + ", contend="
				+ content + "]";
	}
    
    
}