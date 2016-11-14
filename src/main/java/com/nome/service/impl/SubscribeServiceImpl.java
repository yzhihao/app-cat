package com.nome.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nome.dao.SubscribeMapper;
import com.nome.dao.UserMapper;
import com.nome.po.Subscribe;
import com.nome.po.User;
import com.nome.service.SubscribeService;
import com.nome.service.base.impl.BaseServiceImpl;
import com.nome.util.ConnectUtil;
import com.nome.util.StringUtil;

@Service
public class SubscribeServiceImpl extends BaseServiceImpl<Subscribe> implements SubscribeService {

	@Resource
	private SubscribeMapper subscribeMapper;
	
	@Resource
	private UserMapper userMapper;

	@Resource
	public void setSubscribeMapper(SubscribeMapper subscribeMapper) {
		super.setBaseDao(subscribeMapper);
	}

	@Override
	public List<Subscribe> queryByUser(int userId) {
		List<Subscribe> list = subscribeMapper.queryByUser(userId);
		return list;
	}

	@Override
	public List<Subscribe> queryByApp(int appId) {
		List<Subscribe> list = subscribeMapper.queryByApp(appId);
		return list;
	}

	@Override
	public int changePrice(int id,String price) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("price", price);
		return subscribeMapper.changePrice(map);
	}

	@Transactional
	@Override
	public boolean cancel(int id,int userId) {
		
		boolean statement1 = subscribeMapper.cancel(id) == 1?true:false;
		
		boolean statement2 = userMapper.desCurNum(userId) == 1?true:false;
		
		return statement1&&statement2;
	}

	@Transactional
	@Override
	public int addSubscribe(int userId, String url, String price) {
		Map<String,Object> map = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		String tempUrl = null;
		String appId = null;
		if(ConnectUtil.request(url)) {
			if(url.endsWith(".html")) {
				tempUrl = url.substring(url.lastIndexOf("-")+1);
				appId = tempUrl.substring(0, tempUrl.lastIndexOf("."));
			} else {
				appId = url.substring(url.lastIndexOf("/")+3);
			}
			if(!StringUtil.isAppId(appId))  {
				return 4;
			}
		} else {
			return 5;
		}
		map.put("userId", userId);
		map.put("appId", appId);
		User temp = userMapper.queryOne(userId);
		if(temp.getCurSub()<temp.getAllSub()) {
			List<Subscribe> list = subscribeMapper.checkRepeat(map);
			if(!list.isEmpty()) {
				if(list.get(0).getIscancel() == 1) {
					subscribeMapper.recall(list.get(0).getId());
					userMapper.updateCurNum(list.get(0).getUserId());
					return 1;
				} else return 2;
			} else {
				Subscribe sub = new Subscribe();
				sub.setAppId(Integer.parseInt(appId));
				sub.setUserId(userId);
				sub.setLowrest(price);
				sub.setTime(sdf.format(date));
				sub.setIscancel(0);
				subscribeMapper.insert(sub);
				userMapper.updateCurNum(userId);
			}
			return 1;
		} else {
			return 3;
		}
	}

	@Override
	public List<Subscribe> queryAllSubscribe(int userId) {
		return subscribeMapper.queryAllSubscribe(userId);
	}
	
	
	
}
