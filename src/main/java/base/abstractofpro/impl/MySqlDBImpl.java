package base.abstractofpro.impl;

import base.abstractofpro.DB;

/**
 * mysql的db实现
 * 
 * @author yanbin
 * 
 */
public class MySqlDBImpl implements DB {

	@Override
	public void save() {
		System.out.println("mysql save");
	}

}
