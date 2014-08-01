package web.mvc.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import web.mvc.service.DbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * spring mvc 控制器
 * 
 * @author yanbin
 * 
 */
@Controller
@RequestMapping("/db.do")
public class DbController {

	@Autowired
	private DbService dbService;

	/**
	 * 操作 GET方法
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(params = "method=oper", method = RequestMethod.GET)
	public String dbOper(ModelMap model, HttpServletRequest request) {
		// spring ModelMap 存放的属性就在request的作用域
		model.addAttribute("do", "dbOper");

		// 返回页面
		return "db";
	}

	/**
	 * 操作session ：获取session ， servletContext ，webroot路径
	 * 
	 * @param request
	 * 
	 */
	@SuppressWarnings("unused")
	private void operSession(HttpServletRequest request) {
		// 获取session
		HttpSession session = request.getSession();
		// 获取servletContext
		ServletContext sctx = session.getServletContext();
		// 获取webroot 根路径
		String rootPath = sctx.getRealPath("/");
	}

	/**
	 * 操作 POST方法<br>
	 * 
	 * @RequestParam 注解，指定参数对应的页面的名字，不需要匹配方法参数名
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(params = "method=oper", method = RequestMethod.POST)
	public String dbOper(@RequestParam("dbName") String name, String dbName,
			ModelMap model) {
		dbService.dbOper();
		model.addAttribute("result", "Success");
		// 返回页面
		return "db";
	}

	/**
	 * forward跳转：服务器间的跳转。<br>
	 * 1、一次请求。 2、浏览器连接不会变。 3、当前页面刷新会再次执行原方法
	 * 
	 * @return
	 */
	@RequestMapping(params = "method=forward", method = RequestMethod.GET)
	public String forward() {
		// request.getRequestDispatcher("").forward(request, response);
		return "forward:db.do?method=oper";
	}

	/**
	 * 重定向：服务器客户端之间跳转。<br>
	 * 1、后退原页面将失效。 2、页面刷新不会再次调用原方法。 3、实质是两次请求。 4、url会发生改变。<br>
	 * 作用之一：可避免重复提交。
	 * 
	 * @return
	 */
	@RequestMapping(params = "method=redirect", method = RequestMethod.GET)
	public String redirect() {
		// response.sendRedirect("");
		return "redirect:db.do?method=oper";
	}
}
