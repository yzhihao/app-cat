package com.nome.vo;

import com.nome.po.User;

public class UserVo {
	private Integer id;

    private String name;

    private String email;

    private Integer curSub;

    private Integer allSub;

    
    public static UserVo changeToVo(User user) {
    	UserVo vo = new UserVo();
    	
    	vo.setAllSub(user.getAllSub());
    	vo.setCurSub(user.getCurSub());
    	vo.setEmail(user.getEmail());
    	vo.setId(user.getId());
    	vo.setName(user.getName());
    	
    	return vo;
    }
    
    
    
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
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
    
    
    
}
