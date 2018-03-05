package cn.test.api.impl;



import com.alibaba.dubbo.config.annotation.Service;

import cn.test.api.ISay;

// @Service("sayService")
@Service( version = "1.0.0" )
public class SayImpl implements ISay {

	@Override
	public void say(String msg) {
		System.out.println("=====================");
		System.out.println(Thread.currentThread().getName() + " => " + msg);
		System.out.println("---------------------");
	}

}
