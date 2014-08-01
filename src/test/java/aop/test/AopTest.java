package aop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.annotation.Business;
import aop.base.IBaseBusiness;
import aop.schema.AspectBusiness;

public class AopTest {

	@Test
	public void baseAopTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop/base_aop.xml");
		IBaseBusiness iBusiness = (IBaseBusiness) context.getBean("businessProxy");
		// iBusiness.delete("猫");
		iBusiness.add("猫");
		// iBusiness.modify("猫");
	}

	@Test
	public void schemaAopTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop/schema_aop.xml");
		AspectBusiness business = (AspectBusiness) context.getBean("aspectBusiness");
		business.delete("猫");
	}

	@Test
	public void annotationAopTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop/annotation_aop.xml");
		Business business = (Business) context.getBean("business");
		business.delete("猫");
	}

}
