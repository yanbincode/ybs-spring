package base.abstractofpro.impl;

import base.abstractofpro.DB;

/**
 * sql server
 * 
 * @author yanbin
 * 
 */
public class MsSqlDBImpl implements DB {

	@Override
	public void save() {
		System.out.println("sql server save");
	}

}
