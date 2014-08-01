package base.objectofpro.client;

import base.objectofpro.MsSqlDB;
import base.objectofpro.MySqlDB;
import base.objectofpro.OracleDB;

/**
 * 客户端调用
 * 
 * @author yanbin
 * 
 */
public class Client {

	public void oracleSave() {
		OracleDB oracle = new OracleDB();
		oracle.save();
	}

	public void mysqlSave() {
		MySqlDB mysqlDB = new MySqlDB();
		mysqlDB.save();
	}

	public void mssqlSave() {
		MsSqlDB mssqlDB = new MsSqlDB();
		mssqlDB.save();
	}

}
