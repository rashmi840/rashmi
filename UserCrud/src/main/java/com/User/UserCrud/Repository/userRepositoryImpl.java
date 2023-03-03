package com.User.UserCrud.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.User.UserCrud.model.user;
@Repository
public class userRepositoryImpl implements userRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String INSERT_USER_QUERY = "INSERT INTO User(id,first_name,last_name,email) values(?,?,?,?)";
	private static final String UPDATE_USER_BY_ID_QUERY = "UPDATE User SET first_name=?,last_name=?,email=? WHERE id=?";
	private static final String DELETE_USER_BY_ID = "DELETE FROM User WHERE id=?";
	private static final String GET_USER_QUERY = "SELECT * from User";
	
	@Override
	public user saveUser(user user) {
		jdbcTemplate.update(INSERT_USER_QUERY,user.getId(),user.getFirst_name(),user.getLast_name(),user.getEmail());
		return user;
	}

	@Override
	public user updateUser(user user) {
		jdbcTemplate.update(UPDATE_USER_BY_ID_QUERY,user.getFirst_name(),user.getLast_name(),user.getEmail(),user.getId());
		return user;
	}

	@Override
	public String deleteUser(int id) {
		jdbcTemplate.update(DELETE_USER_BY_ID,id);
		return "User got deleted" + id;
	}

	@Override
	public List<user> getAllUser() {
		return jdbcTemplate.query(GET_USER_QUERY,(rs, rowNum) ->{
			return new user(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("email"));
		});
	}

}
