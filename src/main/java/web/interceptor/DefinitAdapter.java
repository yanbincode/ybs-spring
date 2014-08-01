package web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 自定义拦截器<br>
 * 第二种方法：继承HandlerInterceptorAdapter抽象类，可选择的实现其中的方法。<br>
 * 这种实现比较好，只需要重写其中需要的方法
 * 
 * @author yanbin
 * 
 */
public class DefinitAdapter extends HandlerInterceptorAdapter {

	/**
	 * 进入controller 之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("HandlerInterceptorAdapter preHandle");
		return true;
	}

	/**
	 * 最后执行，一般用于资源回收
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("HandlerInterceptorAdapter afterCompletion");
	}

	/**
	 * 出controller时，进入页面之前执行
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("HandlerInterceptorAdapter postHandle");
	}

}
