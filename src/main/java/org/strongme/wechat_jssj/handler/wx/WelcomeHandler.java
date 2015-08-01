package org.strongme.wechat_jssj.handler.wx;

import java.util.Map;

import org.springframework.stereotype.Component;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutNewsMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutNewsMessage.Item;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

@Component("welcomeHandler")
public class WelcomeHandler implements WxMpMessageHandler{

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) throws WxErrorException {
		WxMpUser user = wxMpService.userInfo(wxMessage.getFromUserName(),"zh_CN");
		Item item1 = new Item();item1.setTitle(user.getNickname());
		String tmp = "欢迎您，\n来自"+user.getCountry()+"-"+user.getProvince()+"-"+user.getCity()+"的"+user.getNickname()+"\n您发送的是"+wxMessage.getMsgType()+"类型的消息"+(wxMessage.getEventKey()!=null?("\r\n事件Key:"+wxMessage.getEventKey()):"");
		if(WxConsts.XML_MSG_VOICE.equals(wxMessage.getMsgType())) {
			String Recognition = wxMessage.getRecognition()==null?"":wxMessage.getRecognition();
			if(!"".equals(Recognition)) {
				tmp+="\n你发送的语音识别结果为:\n"+Recognition;
			}
		}
		item1.setDescription(tmp);
		item1.setPicUrl(user.getHeadImgUrl());
		item1.setUrl("https://wx.ngrok.io");
		WxMpXmlOutNewsMessage m2 = WxMpXmlOutMessage.NEWS().addArticle(item1).fromUser(wxMessage.getToUserName()).toUser(wxMessage.getFromUserName()).build();
		return m2;
	}

}
