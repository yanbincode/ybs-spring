package ioc.annotation.bean.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ioc.bean.DB;

@Component("oracle")
@Scope(value = "singleton")
public class OracleDBImpl implements DB {

	private String username;
	private String password;
	private int links;

	public void save() {
		System.out.println("i am oracle db connect");
		System.out.println(username);
		System.out.println(password);
	}

	/**
	 * @PostConstruct 容器初始化方法
	 */
	@PostConstruct
	public void init() {
		System.out.println("init");
	}

	/**
	 * @PreDestroy 容器销毁时调用方法
	 */
	@PreDestroy
	public void destroy() {
		System.out.println("destroy");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLinks() {
		return links;
	}

	public void setLinks(int links) {
		this.links = links;
	}

}
