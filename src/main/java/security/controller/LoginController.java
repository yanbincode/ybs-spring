package security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 登陆控制器
 * 
 * @author yanbin
 * 
 */
@Controller
@RequestMapping("/login.do")
public class LoginController {

	/**
	 * 转向登陆页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "method=login", method = RequestMethod.GET)
	public String login() {
		return "security/login";
	}

	/**
	 * 提交页面，进行登陆验证
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping(params = "method=login", method = RequestMethod.POST)
	public String login(String userName, String password) {
		return "";
	}

	/**
	 * 登陆成功转向页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "method=success", method = RequestMethod.GET)
	public String success() {
		return "security/success";
	}

	/**
	 * 登陆失败转向页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "method=fail", method = RequestMethod.GET)
	public String fail() {
		return "security/fail";
	}

	/**
	 * 成功注销跳转的页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "method=logout", method = RequestMethod.GET)
	public String logout() {
		return "security/logout";
	}

	/**
	 * session失效跳转的页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "method=timeout", method = RequestMethod.GET)
	public String timeout() {
		return "security/timeout";
	}
	
}
