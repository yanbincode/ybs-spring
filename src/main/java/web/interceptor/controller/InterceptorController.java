package web.interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/interceptor.do")
public class InterceptorController {

	/**
	 * 用于测试拦截器的请求方法
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(params = "method=interceptor", method = RequestMethod.GET)
	public String interceptor(ModelMap model) {
		return "ok";
	}

}
