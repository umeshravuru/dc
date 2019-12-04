package com.drchrono.dc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PatientIDMapper implements RowMapper<String> {


  @Override
  public String mapRow (ResultSet rs, int rowNum) throws SQLException {
    return rs.getString("id");
  }
}
