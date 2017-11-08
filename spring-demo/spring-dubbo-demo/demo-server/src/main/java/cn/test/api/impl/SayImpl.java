package cn.test.api.impl;


import org.springframework.stereotype.Service;

import cn.test.api.ISay;

@Service("sayService")
public class SayImpl implements ISay {

	@Override
	public void say(String msg) {
		System.out.println("=====================");
		System.out.println(Thread.currentThread().getName() + " => " + msg);
		System.out.println("---------------------");
	}

}
