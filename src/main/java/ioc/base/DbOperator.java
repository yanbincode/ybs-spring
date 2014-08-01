package ioc.base;

import ioc.base.role.DbIntf;
import ioc.base.role.MySqlDbImpl;

/**
 * IOC:控制反转 /DI:依赖注入<br>
 * 核心作用为了解耦。比如：DB操作，在操作类中我只考虑操作的行为。不用去考虑到哪个DB的操作，至于哪个DB的操作又Spring注入进来。<br>
 * 依赖注入：构造方法注入 ； 属性注入 ； 接口注入（接口注入和属性注入效果相同，却需要声明一个接口。用的不多）
 * 
 * 
 * @author yanbin
 * 
 */
public class DbOperator {

	private DbIntf db;

	/**
	 * 如果没有依赖注入的话，就算利用多态接口实现，但是在DB操作的类中还是会耦合具体的哪个数据库选择
	 */
	public void operateNoIOC() {
		// 指定mysql数据库实现
		DbIntf dbNoIOC = new MySqlDbImpl();
		dbNoIOC.save();
	}

	/**
	 * 空构造
	 */
	public DbOperator() {
	}

	/**
	 * 提供构造方法，供构造方法注入
	 * 
	 * @param db
	 */
	public DbOperator(DbIntf db) {
		this.db = db;
	}

	/**
	 * 提供属性方法，供属性方式注入
	 * 
	 * @param db
	 */
	public void setter(DbIntf db) {
		this.db = db;
	}

	/**
	 * 具体操作，不关心任何数据库！解耦
	 */
	public void operate() {
		// 增 删 改
		db.save();
		db.update();
		db.delete();
	}

}
