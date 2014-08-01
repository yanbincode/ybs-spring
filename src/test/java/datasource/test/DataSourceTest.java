package datasource.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import datasource.dao.OracleDB;

public class DataSourceTest {

	@Test
	public void select() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("datasource/datasource.xml");
		OracleDB oracle = (OracleDB) ctx.getBean("oracle");
		oracle.select();
	}

}
