package transaction.tx.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component(value = "oracle")
public class OracleDB {

	@Resource
	private JdbcTemplate jdbcTemplate;

	public void save() {
		String sql = "insert into student(stu_id,stu_name,stu_gender,stu_age) values (11,'jinhu','0',20) ";
		jdbcTemplate.execute(sql);
		// throw new RuntimeException("roll back !");
	}

	public void select() {
		String sql = "select * from student ";
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> map : result) {
			System.out.println(map.get("stu_name"));
		}
	}

}
