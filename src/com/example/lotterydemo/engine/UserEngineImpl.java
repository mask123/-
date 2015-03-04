package com.example.lotterydemo.engine;

import com.example.lotterydemo.bean.User;



public class UserEngineImpl {

	/**
	 * 用户登录
	 * @param user
	 */
	public void login(User user){
		/*
		①获取登录用的xml
		创建登录用的Element
		设置用户数据
		Message.getxml(element)

		②(代码不变)发送xml到服务器端，等待回复
		HttpCLientUtil.sendxml
		判断数据流非空	

		③数据的校验（md5数据的校验）
		原始数据返原：时间戳（解析）+密码（常量）+body明文(解析+解密DES)

		timestamp+diges+body
		利用工具生产手机端的MD5
		将手机端与服务器的进行对比
		
		④请求结果的数据处理
		body部分的第二次解析，解析明文内容
		*/
	}
}
