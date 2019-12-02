package com.drchrono.dc.mapper;

import com.drchrono.dc.dto.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

  @Override
  public User mapRow (ResultSet rs, int rowNum) throws SQLException {
    User user = new User();
    user.setId(Integer.parseInt(rs.getString("id")));
    return user;
  }

}