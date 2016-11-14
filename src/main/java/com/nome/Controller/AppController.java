package com.nome.Controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nome.service.AppService;
import com.nome.util.PageUtil;
import com.nome.vo.result.Result;

@Controller
@RequestMapping("/app")
public class AppController {

	@Resource
	private AppService appService;
	
	/**
	 * 根据标签查询相应的app
	 * @param tag		标签
	 * @param page		每页的信息
	 * @return
	 */
	@RequestMapping("/queryByTag")
	@ResponseBody
	public Result queryByTag(int tag, PageUtil page) {
		Result result = new Result();
		page = appService.queryByTag(tag, page);
		result.setResult(true);
		result.setData(page);
		return result;
	}
	
	 
	/**
	 * 根据app的名字 或者app的开发者
	 * @param keyword		关键字
	 * @param page			每页的信息
	 * @return
	 */
	@RequestMapping("/findLike")
	@ResponseBody
	public Result findLike(String keyword,PageUtil page) {
		Result result = new Result();
		page = appService.findLike(keyword, page);
		result.setResult(true);
		result.setData(page);
		return result;
	}
	
}
