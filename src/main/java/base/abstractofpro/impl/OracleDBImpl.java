package base.abstractofpro.impl;

import base.abstractofpro.DB;

/**
 * oracle
 * 
 * @author yanbin
 * 
 */
public class OracleDBImpl implements DB {

	@Override
	public void save() {
		System.out.println("oracle save");
	}

}
