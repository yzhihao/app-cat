package com.nome.po;

public class User {
    private Integer id;

    private String name;

    private String password;

    private String email;

    private Integer status;

    private Integer curSub;

    private Integer allSub;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCurSub() {
        return curSub;
    }

    public void setCurSub(Integer curSub) {
        this.curSub = curSub;
    }

    public Integer getAllSub() {
        return allSub;
    }

    public void setAllSub(Integer allSub) {
        this.allSub = allSub;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", status="
				+ status + ", curSub=" + curSub + ", allSub=" + allSub + "]";
	}
    
    
}