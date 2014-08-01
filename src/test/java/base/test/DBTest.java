package base.test;

import base.objectofpro.client.Client;

import org.junit.Test;

import base.abstractofpro.impl.MsSqlDBImpl;
import base.abstractofpro.impl.MySqlDBImpl;
import base.abstractofpro.impl.OracleDBImpl;

/**
 * object to object 编程测试
 * 
 * @author yanbin
 * 
 */
public class DBTest {

	/**
	 * 不同的存储库，需要不同的对象指定，声明不同的对象
	 */
	@Test
	public void objectSave() {
		Client client = new Client();
		client.oracleSave();
		client.mysqlSave();
		client.mssqlSave();
	}

	@Test
	public void abstractSave() {
		base.abstractofpro.client.Client client = new base.abstractofpro.client.Client();
		client.save(new OracleDBImpl());
		client.save(new MySqlDBImpl());
		client.save(new MsSqlDBImpl());
	}

}
