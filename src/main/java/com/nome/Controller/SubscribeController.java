package com.nome.Controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nome.po.Subscribe;
import com.nome.service.SubscribeService;
import com.nome.util.ConnectUtil;
import com.nome.vo.result.Result;

@Controller
@RequestMapping("/subscribe")
public class SubscribeController {

	@Resource
	private SubscribeService subscribeService;
	
	/**
	 * 查询用户订阅的app
	 * @param userId	用户id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryByUser")
	public Result queryByUser(int userId) {
		Result result = new Result();
		List<Subscribe> list = subscribeService.queryByUser(userId);
		result.setData(list);
		result.setResult(true);
		return result;
	}
	
	/**
	 * 查询那些用户订阅了这些app
	 * @param appId		appid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryByApp")
	public Result queryByApp(int appId) {
		Result result = new Result();
		List<Subscribe> list = subscribeService.queryByApp(appId);
		result.setData(list);
		result.setResult(true);
		return result;
	}
	
	
	/**
	 * 用户自定义订阅	
	 * @param url		订阅的appURL
	 * @param userId	用户的id
	 * @param price		用户的预期价格
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addSubscribe")
	public Result addSubscribe(String url,int userId,String price) {
		Result result = new Result();
		int statement = subscribeService.addSubscribe(userId, url, price);
		if(statement == 1) {
			result.setResult(true);
		}
		else if(statement == 2) {
			result.setResult(false);
			result.setInformation("该款app已经订阅了");
		} else if(statement == 3) {
			result.setResult(false);
			result.setInformation("你的订阅次数已用完");
		} else if(statement == 4 || statement == 5) {
			result.setResult(false);
			result.setInformation("输入的URL是非法的");
		}
		return result;
	}
	
	/**
	 * 取消订阅
	 * @param id			appid
	 * @param userId		用户id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/cancelSubscribe")
	public Result cancelSubscribe(int id,int userId) {
		Result result = new Result();
		boolean statement = subscribeService.cancel(id,userId);
		if(statement) {
			result.setResult(true);
		} else {
			result.setResult(false);
			result.setInformation("取消失败");
		}
		
		return result;
	}
	
	
	/**
	 * 查询该用户的历史订阅记录
	 * @param userId	用户的id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryAllSubscribe")
	public Result queryAllSubscribe(int userId) {
		Result result = new Result();
		List<Subscribe> list = subscribeService.queryAllSubscribe(userId);
		result.setData(list);
		result.setResult(true);	
		return result;
	}
	
	
	/**
	 * 用来判断用户输入的URL是否为指定网站的有效链接
	 * @param url
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/connect") 
	public Result connect(String url) {
		
		Result result = new Result();
		result.setResult(ConnectUtil.request(url));
		
		return result;
		
	}
	
	/**
	 * 通过appid来订阅
	 * @param appId			appid
	 * @param userId		用户的id
	 * @param price			可接受价格
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addSubscribeByAppId")
	public Result addSubscribeByAppId(int appId,int userId,String price) {
		Result result = new Result();
		int statement = subscribeService.addSubscribeByAppId(appId, userId, price);
		if(statement == 1) {
			result.setResult(true);
		}
		else if(statement == 2) {
			result.setResult(false);
			result.setInformation("该款app已经订阅了");
		} else if(statement == 3) {
			result.setResult(false);
			result.setInformation("你的订阅次数已用完");
		} else if(statement == 4) {
			result.setResult(false);
			result.setInformation("没有该app");
		}
		return result;
	}
	
}
