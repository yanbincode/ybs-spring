package ioc.oper;

import ioc.bean.DB;
import ioc.sim.BeanFactory;
import ioc.sim.ClassPathXmlApplicationContext;

/**
 * 实例化spring容器
 * 
 * @author yanbin
 * 
 */
public class InstanceSimContext {

	/**
	 * 类路径下寻找配置文件 (建议使用)
	 */
	public void instanceClassPath() {
		BeanFactory context = new ClassPathXmlApplicationContext("sim/ioc.xml");
		DB db = (DB) context.getBean("oracle");
		db.save();
	}

}
