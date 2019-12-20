package com.drchrono.dc.mapper;

import com.drchrono.dc.dto.Patient;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PatientMapper implements RowMapper<Patient> {

  @Override
  public Patient mapRow (ResultSet rs, int rowNum) throws SQLException {
    Patient patient = new Patient();
    patient.setId(Integer.parseInt(rs.getString("id")));
    patient.setMiddle_name(rs.getString("middle_name"));
    patient.setFirst_name(rs.getString("first_name"));
    patient.setLast_name(rs.getString("last_name"));
    patient.setDate_of_birth(rs.getString("date_of_birth"));
    patient.setGender(rs.getString("gender"));
    patient.setUpdated_at(rs.getString("updated_dttm"));
    return patient;
  }

}