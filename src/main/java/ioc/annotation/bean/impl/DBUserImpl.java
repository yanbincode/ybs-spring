package ioc.annotation.bean.impl;

import ioc.annotation.bean.DBUser;
import ioc.bean.DB;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Component 默认key是mysqlDBImpl ； value是对象实例。也可以用value属性直接指定。
 * @author yanbin
 * 
 */
@Component("dbUser")
public class DBUserImpl implements DBUser {

	private String useDbName;

	/**
	 * 2、@Autowired注解在属性上，则不需要set方法存在。属性注入
	 */
	@Autowired
	@Qualifier("oracle")
	private DB oracle;
	/**
	 * 2、@Resource同样也能在属性，和构造方法参数上面使用。名字匹配，或者用name属性指定名字
	 */
	@Resource
	private DB mysql;

	@Override
	public void save() {
		System.out.println(useDbName);
		oracle.save();
		mysql.save();
	}

	/**
	 * 3、@Autowired 注解在构造方法，注解在参数都是可以的
	 * 
	 * @param oracle
	 */
	// @Autowired
	// public DBUserImpl(DB oracle) {
	// this.oracle = oracle;
	// }

	public String getUseDbName() {
		return useDbName;
	}

	public void setUseDbName(String useDbName) {
		this.useDbName = useDbName;
	}

	public DB getOracle() {
		return oracle;
	}

	/**
	 * 1、@Autowired 在set方法上注入，默认是以byType的方式来找实例对象<Br>
	 * 如果存在多个相同类型的bean，可以用@Qualifier注解 name指定
	 * 
	 * @param oracle
	 */
	@Autowired
	@Qualifier(value = "oracle")
	public void setOracle(DB oracle) {
		this.oracle = oracle;
	}

	public DB getMysql() {
		return mysql;
	}

	/**
	 * 1、@Resource 在set方法上注入，默认是以byName的方式来找实例对象，并且setter的名字匹配<Br>
	 * 可以用 name属性来指定名称，如果名称找不到，会按类型来匹配
	 * 
	 * @param mysql
	 */
	@Resource(name = "mysql")
	public void setMysql(DB mysql) {
		this.mysql = mysql;
	}

}
