package com.nome.po;

public class Answer {
	private Integer id;

	private Integer userId;

	private String time;

	private Integer questionId;

	private String content;

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

	public Answer() {
		super();
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time == null ? null : time.trim();
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public Answer(Integer id, Integer userId, String time, Integer questionId, String content) {
		super();
		this.id = id;
		this.userId = userId;
		this.time = time;
		this.questionId = questionId;
		this.content = content;
	}

}