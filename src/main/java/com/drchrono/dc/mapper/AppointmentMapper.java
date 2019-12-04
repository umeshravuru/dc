package com.drchrono.dc.mapper;

import com.drchrono.dc.dto.Appointment;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class AppointmentMapper implements RowMapper<Appointment> {

  @Override
  public Appointment mapRow (ResultSet rs, int rowNum) throws SQLException {
    Appointment appointment = new Appointment();
    appointment.setId(rs.getString("appointmentid"));
    appointment.setAllow_overlapping(rs.getBoolean("allow_overlapping"));
    appointment.setAppt_is_break(rs.getBoolean("appt_is_break"));
    appointment.setBase_recurring_appointment(rs.getInt("base_recurring_appointment"));
    appointment.setColor(rs.getString("color"));
    appointment.setCreated_at(rs.getString("created_at"));
    appointment.setDeleted_flag(rs.getBoolean("deleted_flag"));
    appointment.setDoctor(rs.getInt("doctor"));
    appointment.setDuration(rs.getInt("duration"));
    appointment.setExam_room(rs.getInt("exam_room"));
    appointment.setIs_walk_in(rs.getBoolean("is_walk_in"));
    appointment.setNotes(rs.getString("notes"));
    appointment.setOffice(rs.getInt("office"));
    appointment.setPatient(rs.getInt("patient"));
    appointment.setProfile(rs.getInt("profile"));
    appointment.setReason(rs.getString("reason"));
    appointment.setRecurring_appointment(rs.getBoolean("recurring_appointment"));
    appointment.setScheduled_time(rs.getString("scheduled_time"));
    appointment.setStatus(rs.getString("status"));
    appointment.setUpdated_at(rs.getString("updated_at"));

    return appointment;
  }

}