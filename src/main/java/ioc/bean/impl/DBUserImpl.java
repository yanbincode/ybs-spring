package ioc.bean.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import ioc.bean.DB;
import ioc.bean.DBUser;

public class DBUserImpl implements DBUser {
	/** 注入属性：基本类型 */
	private String useDbName;

	/** 注入属性：指定接口 */
	private DB oracle;
	private DB mysql;
	private DB mssql;

	/** 注入属性：集合属性 */
	private Map<String, String> map;
	private List<String> list;
	private Set<String> set;

	/** 注入属性：资源文件对象 */
	private Properties properties;

	/**
	 * 构造方法注入：需要构造方法
	 */
	// public DBUserImpl(String useDbName, DB db) {
	// this.useDbName = useDbName;
	// this.db = db;
	// }

	@Override
	public void save() {
		System.out.println(useDbName);
		oracle.save();
		mysql.save();
		mssql.save();
		resolveMap();
		resolveList();
		resolveSet();
		resolveProperty();
	}

	/**
	 * 指定bean初始化的时候调用方法
	 */
	public void init() {
		System.out.println("init");
	}

	/**
	 * 指定bean销毁时调用的方法
	 */
	public void destroy() {
		System.out.println("destroy");
	}

	/**
	 * 解析map
	 */
	private void resolveMap() {
		System.out.println("=========开始解析MAP===========");
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println("key:" + key + " value:" + value);
		}
	}

	/**
	 * 解析list
	 */
	private void resolveList() {
		System.out.println("============开始解析LIST==============");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String value = iterator.next();
			System.out.println(value);
		}
	}

	/**
	 * 解析set
	 */
	private void resolveSet() {
		System.out.println("============开始解析SET==============");
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String value = iterator.next();
			System.out.println(value);
		}
	}

	/**
	 * 解析property
	 */
	private void resolveProperty() {
		System.out.println("============开始解析PROPERTY==============");
		Iterator<Entry<Object, Object>> iterator = properties.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Object, Object> entry = iterator.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			System.out.println("key:" + key + " value:" + value);
		}
	}

	public String getUseDbName() {
		return useDbName;
	}

	public void setUseDbName(String useDbName) {
		this.useDbName = useDbName;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public DB getOracle() {
		return oracle;
	}

	public void setOracle(DB oracle) {
		this.oracle = oracle;
	}

	public DB getMysql() {
		return mysql;
	}

	public void setMysql(DB mysql) {
		this.mysql = mysql;
	}

	public DB getMssql() {
		return mssql;
	}

	public void setMssql(DB mssql) {
		this.mssql = mssql;
	}

}
