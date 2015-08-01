package org.strongme.wechat_jssj.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("")
	public String index() {
		return "modules/sys/main/index";
	}
	
}
