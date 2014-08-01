package ioc.base;

import ioc.base.role.DbIntf;
import ioc.base.role.OracleDbImpl;

/**
 * 装配器，起到注入的作用，核心的解耦（Spring做的事情）
 * 
 * @author yanbin
 * 
 */
public class Assembler {

	/**
	 * 构造方法注入
	 */
	public void assembleByConstructor() {
		DbIntf db = new OracleDbImpl();
		DbOperator dbOperator = new DbOperator(db);
		dbOperator.operate();
	}

	/**
	 * 属性注入。必须提供setter()方法
	 */
	public void assembleByproperty() {
		DbIntf db = new OracleDbImpl();
		DbOperator dbOperator = new DbOperator();
		dbOperator.setter(db);
		dbOperator.operate();
	}

}
