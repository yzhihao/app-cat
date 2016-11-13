package com.nome.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.nome.dao.AppMapper;
import com.nome.dao.PushMapper;
import com.nome.dao.UserMapper;
import com.nome.po.App;
import com.nome.po.Push;
import com.nome.po.User;
import com.nome.service.PushService;
import com.nome.service.base.impl.BaseServiceImpl;
import com.nome.util.SendEmail;

@Service
public class PushServiceImpl extends BaseServiceImpl<Push> implements PushService {

	@Resource
	private PushMapper pushMapper;
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private AppMapper appMapper;

	@Resource
	public void setPushMapper(PushMapper pushMapper) {
		this.pushMapper = pushMapper;
	}

	@Scheduled(cron="30 * *  * * ? ")
	@Override
	public void push() {
		if(pushMapper == null) return;
		List<Push> pushList = pushMapper.queryPushApp();
		List<Integer> list = new ArrayList<Integer>();
		User user = null;
		App app = null;
		Push push = null;
		if(pushList == null || pushList.isEmpty()) return;
		else {
			for(int i=0;i<pushList.size();i++) {
				push = pushList.get(i);
				user = userMapper.selectByPrimaryKey(push.getUserId());
				app = appMapper.selectByPrimaryKey(push.getAppId());
				SendEmail.sendPush(user.getEmail(), app.getName(), push);
				list.add(push.getId());
			}
			pushMapper.deletePushs(list);	
		}
	}

	@Override
	public List<Push> queryPushApp() {
		return pushMapper.queryPushApp();
	}
	
	
	
}
