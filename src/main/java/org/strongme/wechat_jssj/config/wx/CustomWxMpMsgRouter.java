package org.strongme.wechat_jssj.config.wx;

import javax.annotation.Resource;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;

public class CustomWxMpMsgRouter extends WxMpMessageRouter{
	
	@Resource
	private WxMpMessageHandler welcomeHandler;	
	
	public CustomWxMpMsgRouter(WxMpService wxMpService) {
		super(wxMpService);
	}
	
	private void init() {
		
		//关注之后发送
		this.rule().async(false).event(WxConsts.EVT_SUBSCRIBE).handler(welcomeHandler).end();
		//文本消息
		this.rule().async(false).handler(welcomeHandler).end();

	}

	public WxMpMessageHandler getWelcomeHandler() {
		return welcomeHandler;
	}

	public void setWelcomeHandler(WxMpMessageHandler welcomeHandler) {
		this.welcomeHandler = welcomeHandler;
	}

	
	
}
