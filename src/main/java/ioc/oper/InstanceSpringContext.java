package ioc.oper;

import ioc.bean.DB;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 实例化spring的读取xml配置，来获取context容器上下文的有多种方法。
 * 
 * @author yanbin
 * 
 */
public class InstanceSpringContext {

	/**
	 * 方法一：利用FileSystemXmlApplicationContext类
	 */
	public ApplicationContext firstMethod() {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("ioc.xml");
		return ctx;
	}

	/**
	 * 方法七：利用ClassPathXmlApplicationContext 类
	 * 
	 * @return
	 */
	public ApplicationContext seventh() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
		return context;
	}

	/**
	 * 方法二：利用：WebApplicationContextUtils <br>
	 * 通过Spring提供的工具类获取ApplicationContext对象
	 * 
	 * @return
	 */
	public ApplicationContext secondMethod() {
		// servletContext 的获取方法：
		// 1,servlet.getServletContext() ；
		// 2,this.getServletContext()
		// 3,request.getSession().getServletContext();
		ServletContext sc = null;
		// 获取失败时抛出异常
		ApplicationContext ctx1 = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
		// 获取失败时返回null
		ApplicationContext ctx2 = WebApplicationContextUtils.getWebApplicationContext(sc);
		return ctx2 == null ? ctx1 : ctx2;
	}

	/**
	 * 方法六：由于spring是注入的对象放在ServletContext中的，
	 * 所以可以直接在ServletContext取出WebApplicationContext 对象
	 * 
	 * @return
	 */
	public ApplicationContext sixthMethod() {
		ServletContext servletContext = null;
		WebApplicationContext ctx = (WebApplicationContext) servletContext
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		return ctx;
	}

	/**
	 * 方法三：继承自抽象类ApplicationObjectSupport <br>
	 * 抽象类ApplicationObjectSupport提供getApplicationContext()方法，
	 * 可以方便的获取到ApplicationContext。
	 * Spring初始化时，会通过该抽象类的setApplicationContext(ApplicationContext
	 * context)方法将ApplicationContext 对象注入。
	 * 
	 * @return
	 */
	public ApplicationContext thirdMethod() {
		// extends ApplicationObjectSupport
		// getApplicationContext()
		return null;
	}

	/**
	 * 方法四：继承自抽象类WebApplicationObjectSupport
	 * 调用getWebApplicationContext()获取WebApplicationContext
	 * 
	 * @return
	 */
	public ApplicationContext fourthMethod() {
		// extends WebApplicationObjectSupport
		// getApplicationContext()
		return null;
	}

	/**
	 * 方法五：实现接口ApplicationContextAware
	 * 实现该接口的setApplicationContext(ApplicationContextcontext)方法，
	 * 并保存ApplicationContext 对象。<br>
	 * Spring初始化时，会通过该方法将ApplicationContext对象注入。
	 * 
	 * @return
	 */
	public ApplicationContext fifthMethod() {
		// private static ApplicationContext applicationContext;
		// 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.

		// public void setApplicationContext(ApplicationContext
		// applicationContext) {
		// this.applicationContext = applicationContext;
		// }
		// 下面就可以直接使用applicationContext的容器了
		return null;
	}

	public void operBean(ApplicationContext context) {
		DB db = (DB) context.getBean("oracle");
		db.save();
	}

}
