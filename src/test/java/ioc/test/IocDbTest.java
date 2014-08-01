package ioc.test;

import ioc.bean.DBUser;
import ioc.oper.InstanceSimContext;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocDbTest {

	public void simIoc() {
		InstanceSimContext isc = new InstanceSimContext();
		isc.instanceClassPath();
	}

	@Test
	public void ioc() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ioc/ioc.xml");
		DBUser user = (DBUser) ctx.getBean("dbUser");
		user.save();
	}

	public void annotationIoc() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ioc/annotation_ioc.xml");
		ioc.annotation.bean.DBUser user = (ioc.annotation.bean.DBUser) ctx.getBean("dbUser");
		user.save();
		// ctx.destroy();
	}

}
