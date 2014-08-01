package base.abstractofpro.client;

import base.abstractofpro.DB;

/**
 * 客户端调用
 * 
 * @author yanbin
 * 
 */
public class Client {

	/**
	 * 保存操作，传入不同的对象，调用不同的方法(父类引用子类对象)
	 * 
	 * @param db
	 */
	public void save(DB db) {
		db.save();
	}

}
