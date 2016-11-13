package com.nome.service.impl;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nome.service.PushService;
import com.nome.service.ScheduledService;

@Component
public class ScheduledServiceImpl implements ScheduledService {
	
	@Override
	public void test() {
		System.out.println("1---------------------");
	}

}
