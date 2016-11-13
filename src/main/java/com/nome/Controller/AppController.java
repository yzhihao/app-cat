package com.nome.Controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nome.po.App;
import com.nome.service.AppService;
import com.nome.vo.result.Result;

@Controller
public class AppController {

	@Resource
	private AppService appService;
	
	/**
	 * 根据标签查询相应的app
	 * @param tag			1代表中国的	2代表国外的
	 * @param page			页数
	 * @param size			每页的app数目
	 * @return
	 */
	@RequestMapping("/queryByTag")
	@ResponseBody
	public Result queryByTag(int tag, int page, int size) {
		Result result = new Result();
		if(size == 0) size = 3;
		if(page == 0) page = 1;
		
		int offset = (page-1)*size;
		int limit = page*size;
		
		List<App> app = appService.queryByTag(tag, offset, limit);
		result.setResult(true);
		result.setData(app);
		
		return result;
	}
	
	
	/**
	 * 模糊查询app     根据app的名字 或者app的开发者
	 * @param keyword	关键字
	 * @param page		页数
	 * @param size		每页的app数目
	 * @return
	 */
	@RequestMapping("/findLike")
	@ResponseBody
	public Result findLike(String keyword, int page, int size) {
		Result result = new Result();
		if(size == 0) size = 3;
		if(page == 0) page = 1;
		
		int offset = (page-1)*size;
		int limit = page*size;
		List<App> app = appService.findLike(keyword,offset,limit);
		result.setResult(true);
		result.setData(app);
		
		return result;
	}
	
}
