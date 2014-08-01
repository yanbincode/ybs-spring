package transaction.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import transaction.tx.annotation.dao.OracleDB;

public class TransactionAnnoTest {

	@Test
	public void saveAnno() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("transaction/tx_annotation.xml");
		OracleDB oracle = (OracleDB) ctx.getBean("oracle");
		oracle.save();
	}

	@Test
	public void selectAnno() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("transaction/tx_annotation.xml");
		OracleDB oracle = (OracleDB) ctx.getBean("oracle");
		oracle.select();
	}

}
