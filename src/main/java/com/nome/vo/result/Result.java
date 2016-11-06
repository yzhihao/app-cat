package com.nome.vo.result;

/**
 * 用于交互结果类
 * @declared result 判断请求是否执行成功
 * @declared data 后台封装的数据（如果有）
 * @declared information 详细信息。
 */
public class Result
{
	private boolean result = false;
	private Object data;
	private String information = "";
	
	public Result()	
	{	}

	public Result(boolean result)
	{
		this.result = result;
	}

	public Result(boolean result, Object data)
	{
		super();
		this.result = result;
		this.data = data;
	}

	public Result(String information)
	{
		this.information = information;
	}

	public Result(boolean result, Object data, String information)
	{
		this.result = result;
		this.data = data;
		this.information = information;
	}
	
	public boolean isResult()
	{
		return result;
	}
	public void setResult(boolean result)
	{
		this.result = result;
	}
	public Object getData()
	{
		return data;
	}
	public void setData(Object data)
	{
		this.data = data;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
}
