package com.nome.Controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nome.service.AppHistoryInfoService;
import com.nome.vo.result.Result;

@Controller
public class AppHistoryInfoController {

	@Resource
	private AppHistoryInfoService appHistoryInfoService;
	
	/**
	 * 根据app的id查询app的历史价格
	 * @param appId
	 * @return
	 */
	@RequestMapping("queryHistoryPriceByAppId")
	@ResponseBody
	public Result queryHistoryPriceByAppId(int appId) {
		
		Result result = new Result();
		result.setData(appHistoryInfoService.queryHistoryPriceByAppId(appId));
		result.setResult(true);
		return result;
	}
	
	
}
