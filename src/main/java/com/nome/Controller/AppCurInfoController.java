package com.nome.Controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nome.service.AppCurInfoService;
import com.nome.util.PageUtil;
import com.nome.vo.result.Result;

@Controller
@RequestMapping("/appCurInfo")
public class AppCurInfoController {

	@Resource
	private AppCurInfoService appCurInfoService;
	
	/**
	 * 查询当前热门的app  包含国内和国外
	 * @return
	 */
	@RequestMapping("/queryCurApp")
	@ResponseBody
	public Result queryCurApp(PageUtil page) {
		
		//需要分页
		Result result = new Result();
		
		result.setData(appCurInfoService.queryCurAllApps(page));
		result.setResult(true);
		return result;
	}
	
}
