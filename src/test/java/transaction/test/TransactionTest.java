package transaction.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import transaction.tx.dao.OracleDB;

public class TransactionTest {

	@Test
	public void save() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("transaction/tx_xml.xml");
		OracleDB oracle = (OracleDB) ctx.getBean("oracle");
		oracle.save();
	}

	@Test
	public void select() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("transaction/tx_xml.xml");
		OracleDB oracle = (OracleDB) ctx.getBean("oracle");
		oracle.select();
	}

}
