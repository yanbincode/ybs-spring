package web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StopWatch;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 实现一个，监控每次请求到返回的执行代码的时间。可以测试性能。<br>
 * 思路：在preHandle记录开始的时间，在afterCompletion记录结束的时间，就可或者整个页面生成的时间。
 * Spring自带StopWatch工具类来实现时间跟踪，关键一点interceptor不是线程安全的。 我们需要借助threadlocal来实现线程安全。
 * 
 * @author yanbin
 * 
 */
public class SystemTimeAdapter extends HandlerInterceptorAdapter {

	/** 定义线程安全 */
	ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		StopWatch stopWatch = new StopWatch(handler.toString());

		// 放入ThreadLocal中
		stopWatchLocal.set(stopWatch);
		// 开始计时
		stopWatch.start(handler.toString());

		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 从ThreadLocal中拿出StopWatch实例
		StopWatch stopWatch = stopWatchLocal.get();
		// 结束计时
		stopWatch.stop();

		// 获取请求的url
		String currentPath = request.getRequestURI();
		String queryString = request.getQueryString();
		String url = currentPath + (queryString == null ? "" : "?" + queryString);

		// 获取 ，返回的是毫秒
		Long time = stopWatch.getTotalTimeMillis();

		// 输出
		System.out.println("access url path:" + url + " |time:" + time);

		stopWatchLocal.set(null);
	}

}
