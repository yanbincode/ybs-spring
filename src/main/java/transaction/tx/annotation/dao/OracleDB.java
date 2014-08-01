package transaction.tx.annotation.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component(value = "oracle")
@Transactional
public class OracleDB {

	@Resource
	private JdbcTemplate jdbcTemplate;

	public void save() {
		String sql = "insert into student(stu_id,stu_name,stu_gender,stu_age) values (11,'jinhu','0',20) ";
		jdbcTemplate.execute(sql);
		// 事务控制不会提交
		throw new RuntimeException("roll back !");
	}

	// 只读事务
	@Transactional(readOnly = true)
	public void select() {
		String sql = "select * from student ";
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> map : result) {
			System.out.println(map.get("stu_name"));
		}
	}

}
