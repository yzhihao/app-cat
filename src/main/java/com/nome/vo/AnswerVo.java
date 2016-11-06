package com.nome.vo;

import com.nome.po.Answer;

public class AnswerVo {
	
	private Integer id;

    private String title;

    private Integer appId;

    private Integer userId;

    private String time;

    private Integer questionId;

    private String content;
    
    public static Answer changeToPo(AnswerVo vo) {
    	Answer answer = new Answer();
    	
    	
    	return answer;
    }
    
    public static AnswerVo changeToVo(Answer answer) {
    	AnswerVo vo = new AnswerVo();
    	
    	return vo;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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
}
