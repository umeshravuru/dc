package com.drchrono.dc.dto;

import java.util.List;

public class Appointment {

  private String id;
  private Boolean allow_overlapping;
  private Boolean appt_is_break;
  private Integer base_recurring_appointment;
  private String color;
  private String created_at;
  private Boolean deleted_flag;
  private Integer doctor;
  private Integer duration;
  private Integer exam_room;
  private List<String> icd10_codes = null;
  private Boolean is_walk_in;
  private String notes;
  private Integer office;
  private Integer patient;
  private Integer profile;
  private String reason;
  private Boolean recurring_appointment;
  private String scheduled_time;
  private String status;
  private String updated_at;


  public Boolean getAllow_overlapping () {
    return allow_overlapping;
  }

  public void setAllow_overlapping (Boolean allow_overlapping) {
    this.allow_overlapping = allow_overlapping;
  }

  public Boolean getAppt_is_break () {
    return appt_is_break;
  }

  public void setAppt_is_break (Boolean appt_is_break) {
    this.appt_is_break = appt_is_break;
  }

  public Integer getBase_recurring_appointment () {
    return base_recurring_appointment;
  }

  public void setBase_recurring_appointment (Integer base_recurring_appointment) {
    this.base_recurring_appointment = base_recurring_appointment;
  }

  public String getColor () {
    return color;
  }

  public void setColor (String color) {
    this.color = color;
  }

  public String getCreated_at () {
    return created_at;
  }

  public void setCreated_at (String created_at) {
    this.created_at = created_at;
  }

  public Boolean getDeleted_flag () {
    return deleted_flag;
  }

  public void setDeleted_flag (Boolean deleted_flag) {
    this.deleted_flag = deleted_flag;
  }

  public Integer getDoctor () {
    return doctor;
  }

  public void setDoctor (Integer doctor) {
    this.doctor = doctor;
  }

  public Integer getDuration () {
    return duration;
  }

  public void setDuration (Integer duration) {
    this.duration = duration;
  }

  public Integer getExam_room () {
    return exam_room;
  }

  public void setExam_room (Integer exam_room) {
    this.exam_room = exam_room;
  }

  public List<String> getIcd10_codes () {
    return icd10_codes;
  }

  public void setIcd10_codes (List<String> icd10_codes) {
    this.icd10_codes = icd10_codes;
  }

  public String getId () {
    return id;
  }

  public void setId (String id) {
    this.id = id;
  }

  public Boolean getIs_walk_in () {
    return is_walk_in;
  }

  public void setIs_walk_in (Boolean is_walk_in) {
    this.is_walk_in = is_walk_in;
  }

  public String getNotes () {
    return notes;
  }

  public void setNotes (String notes) {
    this.notes = notes;
  }

  public Integer getOffice () {
    return office;
  }

  public void setOffice (Integer office) {
    this.office = office;
  }

  public Integer getPatient () {
    return patient;
  }

  public void setPatient (Integer patient) {
    this.patient = patient;
  }

  public Integer getProfile () {
    return profile;
  }

  public void setProfile (Integer profile) {
    this.profile = profile;
  }

  public String getReason () {
    return reason;
  }

  public void setReason (String reason) {
    this.reason = reason;
  }

  public Boolean getRecurring_appointment () {
    return recurring_appointment;
  }

  public void setRecurring_appointment (Boolean recurring_appointment) {
    this.recurring_appointment = recurring_appointment;
  }

  public String getScheduled_time () {
    return scheduled_time;
  }

  public void setScheduled_time (String scheduled_time) {
    this.scheduled_time = scheduled_time;
  }

  public String getStatus () {
    return status;
  }

  public void setStatus (String status) {
    this.status = status;
  }

  public String getUpdated_at () {
    return updated_at;
  }

  public void setUpdated_at (String updated_at) {
    this.updated_at = updated_at;
  }


  @Override
  public String toString () {
    final StringBuilder sb = new StringBuilder("Appointment{");
    sb.append("allow_overlapping=").append(allow_overlapping);
    sb.append(", appt_is_break=").append(appt_is_break);
    sb.append(", base_recurring_appointment=").append(base_recurring_appointment);
    sb.append(", color='").append(color).append('\'');
    sb.append(", created_at='").append(created_at).append('\'');
    sb.append(", deleted_flag=").append(deleted_flag);
    sb.append(", doctor=").append(doctor);
    sb.append(", duration=").append(duration);
    sb.append(", exam_room=").append(exam_room);
    sb.append(", icd10_codes=").append(icd10_codes);
    sb.append(", id='").append(id).append('\'');
    sb.append(", is_walk_in=").append(is_walk_in);
    sb.append(", notes='").append(notes).append('\'');
    sb.append(", office=").append(office);
    sb.append(", patient=").append(patient);
    sb.append(", profile=").append(profile);
    sb.append(", reason='").append(reason).append('\'');
    sb.append(", recurring_appointment=").append(recurring_appointment);
    sb.append(", scheduled_time='").append(scheduled_time).append('\'');
    sb.append(", status='").append(status).append('\'');
    sb.append(", updated_at='").append(updated_at).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
