package security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 可以访问的资源
 * 
 * @author yanbin
 * 
 */
@Controller
@RequestMapping("/resource.do")
public class ResourceController {

	@RequestMapping(params = "method=add", method = RequestMethod.GET)
	public String add() {
		return "security/resource/add";
	}

	@RequestMapping(params = "method=modify", method = RequestMethod.GET)
	public String modify() {
		return "security/resource/modify";
	}

	@RequestMapping(params = "method=details", method = RequestMethod.GET)
	public String details() {
		return "security/resource/details";
	}

}
