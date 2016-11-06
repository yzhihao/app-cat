package com.nome.vo.result;

import java.util.List;

import com.nome.vo.AnswerVo;

public class AnswerVoResult {
	public boolean isSuccess;
	public int code;
	public List<AnswerVo> vo;
	
	
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<AnswerVo> getVo() {
		return vo;
	}
	public void setVo(List<AnswerVo> vo) {
		this.vo = vo;
	}
	
	
	
}
