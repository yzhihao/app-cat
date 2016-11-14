package com.nome.Controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nome.service.PushService;
import com.nome.vo.result.Result;

@Controller
@RequestMapping("/push")
public class PushController {

	@Resource
	private PushService pushService;
	
	/**
	 * app降价到用户预定的价格时进行推送， 目前只有邮箱推送
	 * @return
	 */
	@RequestMapping("/queryPushApp")
	@ResponseBody
	public Result queryPushApp() {
		Result result =new Result();
		result.setData(pushService.queryPushApp());
		result.setResult(true);
		return result;
	}
	
}
