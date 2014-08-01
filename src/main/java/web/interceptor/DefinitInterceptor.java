package web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * spring中实现拦截器<br>
 * 实现HandlerInterceptor接口，是在org.springframework.web.servlet包下的。
 * 
 * @author yanbin
 * 
 */
public class DefinitInterceptor implements HandlerInterceptor {

	/**
	 * 最后执行，一般用于释放资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e)
			throws Exception {
		System.out.println("HandlerInterceptor afterCompletion 方法");
	}

	/**
	 * 这个方法在出controller 之前执行
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj,
			ModelAndView modelAndView) throws Exception {
		System.out.println("HandlerInterceptor postHandle 方法");
	}

	/**
	 * 这个方法在进入controller之前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		// 返回true ，继续执行controller ，如果为false 则不进入controller
		System.out.println("HandlerInterceptor preHandle 方法");
		return true;
	}

}