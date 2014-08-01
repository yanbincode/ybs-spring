package web.mvc.dao;

import org.springframework.stereotype.Repository;

/**
 * dao层。用repository注解
 * 
 * @author yanbin
 * 
 */
@Repository
public class DbDao {

	public void operation() {
		System.out.println("db oper");
	}

}
