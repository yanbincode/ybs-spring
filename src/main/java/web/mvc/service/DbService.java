package web.mvc.service;

import web.mvc.dao.DbDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * spring mvc 的service层用 @Service 注解
 * 
 * @author yanbin
 * 
 */
@Service
public class DbService {

	@Autowired
	private DbDao dbDao;

	public void dbOper() {
		dbDao.operation();
	}

}
