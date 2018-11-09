package spittr.data;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spittr.Spitter;

@Repository
public class SpitterRepositoryImpl implements SpitterRepository {

	@Autowired
	private JdbcOperations jdbcOperations;
	//JdbcOperations 能够保证JdbcSpitterRepository通过JdbcOperations接口达到与JdbcTemplate保持松耦合
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void addSpitter(Spitter spitter) {
		jdbcTemplate.update("inset into spitter ....", spitter.getUsername());
		
	}

	@Override
	public Spitter findOne(long id) {
		Spitter queryForObject = jdbcOperations.queryForObject("ss", Spitter.class, id);
		return jdbcOperations.queryForObject("select .... ", new SpitterRowMapper() ,id);
		
	}



	
}
final class SpitterRowMapper implements RowMapper<Spitter> {

	@Override
	public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		return new Spitter(rs.getLong("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("username"),rs.getString("email"), rs.getString("password"));
	}


}
