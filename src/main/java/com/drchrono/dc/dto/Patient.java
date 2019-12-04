package com.drchrono.dc.dto;

import java.util.List;

public class Patient {

  private Integer id;
  private String chart_id;
  private String first_name;
  private String middle_name;
  private String last_name;
  private String nick_name;
  private String date_of_birth;
  private String gender;
  private String social_security_number;
  private String race;
  private String ethnicity;
  private String preferred_language;
  private String patient_photo;
  private String patient_photo_date;
  private String patient_payment_profile;
  private String patient_status;
  private String home_phone;
  private String cell_phone;
  private String office_phone;
  private String email;
  private String address;
  private String city;
  private String state;
  private String zip_code;
  private String emergency_contact_name;
  private String emergency_contact_phone;
  private String emergency_contact_relation;
  private String employer;
  private String employer_address;
  private String employer_city;
  private String employer_state;
  private String employer_zip_code;
  private Boolean disable_sms_messages;
  private Integer doctor;
  private String primary_care_physician;
  private String date_of_first_appointment;
  private String date_of_last_appointment;
  private List<Integer> offices = null;
  private String default_pharmacy;
  private String referring_source;
  private String copay;
  private String responsible_party_name;
  private String responsible_party_relation;
  private String responsible_party_phone;
  private String responsible_party_email;
  private String updated_at;

  public Integer getId () {
    return id;
  }

  public void setId (Integer id) {
    this.id = id;
  }

  public String getChart_id () {
    return chart_id;
  }

  public void setChart_id (String chart_id) {
    this.chart_id = chart_id;
  }

  public String getFirst_name () {
    return first_name;
  }

  public void setFirst_name (String first_name) {
    this.first_name = first_name;
  }

  public String getMiddle_name () {
    return middle_name;
  }

  public void setMiddle_name (String middle_name) {
    this.middle_name = middle_name;
  }

  public String getLast_name () {
    return last_name;
  }

  public void setLast_name (String last_name) {
    this.last_name = last_name;
  }

  public String getNick_name () {
    return nick_name;
  }

  public void setNick_name (String nick_name) {
    this.nick_name = nick_name;
  }

  public String getDate_of_birth () {
    return date_of_birth;
  }

  public void setDate_of_birth (String date_of_birth) {
    this.date_of_birth = date_of_birth;
  }

  public String getGender () {
    return gender;
  }

  public void setGender (String gender) {
    this.gender = gender;
  }

  public String getSocial_security_number () {
    return social_security_number;
  }

  public void setSocial_security_number (String social_security_number) {
    this.social_security_number = social_security_number;
  }

  public String getRace () {
    return race;
  }

  public void setRace (String race) {
    this.race = race;
  }

  public String getEthnicity () {
    return ethnicity;
  }

  public void setEthnicity (String ethnicity) {
    this.ethnicity = ethnicity;
  }

  public String getPreferred_language () {
    return preferred_language;
  }

  public void setPreferred_language (String preferred_language) {
    this.preferred_language = preferred_language;
  }

  public String getPatient_photo () {
    return patient_photo;
  }

  public void setPatient_photo (String patient_photo) {
    this.patient_photo = patient_photo;
  }

  public String getPatient_photo_date () {
    return patient_photo_date;
  }

  public void setPatient_photo_date (String patient_photo_date) {
    this.patient_photo_date = patient_photo_date;
  }

  public String getPatient_payment_profile () {
    return patient_payment_profile;
  }

  public void setPatient_payment_profile (String patient_payment_profile) {
    this.patient_payment_profile = patient_payment_profile;
  }

  public String getPatient_status () {
    return patient_status;
  }

  public void setPatient_status (String patient_status) {
    this.patient_status = patient_status;
  }

  public String getHome_phone () {
    return home_phone;
  }

  public void setHome_phone (String home_phone) {
    this.home_phone = home_phone;
  }

  public String getCell_phone () {
    return cell_phone;
  }

  public void setCell_phone (String cell_phone) {
    this.cell_phone = cell_phone;
  }

  public String getOffice_phone () {
    return office_phone;
  }

  public void setOffice_phone (String office_phone) {
    this.office_phone = office_phone;
  }

  public String getEmail () {
    return email;
  }

  public void setEmail (String email) {
    this.email = email;
  }

  public String getAddress () {
    return address;
  }

  public void setAddress (String address) {
    this.address = address;
  }

  public String getCity () {
    return city;
  }

  public void setCity (String city) {
    this.city = city;
  }

  public String getState () {
    return state;
  }

  public void setState (String state) {
    this.state = state;
  }

  public String getZip_code () {
    return zip_code;
  }

  public void setZip_code (String zip_code) {
    this.zip_code = zip_code;
  }

  public String getEmergency_contact_name () {
    return emergency_contact_name;
  }

  public void setEmergency_contact_name (String emergency_contact_name) {
    this.emergency_contact_name = emergency_contact_name;
  }

  public String getEmergency_contact_phone () {
    return emergency_contact_phone;
  }

  public void setEmergency_contact_phone (String emergency_contact_phone) {
    this.emergency_contact_phone = emergency_contact_phone;
  }

  public String getEmergency_contact_relation () {
    return emergency_contact_relation;
  }

  public void setEmergency_contact_relation (String emergency_contact_relation) {
    this.emergency_contact_relation = emergency_contact_relation;
  }

  public String getEmployer () {
    return employer;
  }

  public void setEmployer (String employer) {
    this.employer = employer;
  }

  public String getEmployer_address () {
    return employer_address;
  }

  public void setEmployer_address (String employer_address) {
    this.employer_address = employer_address;
  }

  public String getEmployer_city () {
    return employer_city;
  }

  public void setEmployer_city (String employer_city) {
    this.employer_city = employer_city;
  }

  public String getEmployer_state () {
    return employer_state;
  }

  public void setEmployer_state (String employer_state) {
    this.employer_state = employer_state;
  }

  public String getEmployer_zip_code () {
    return employer_zip_code;
  }

  public void setEmployer_zip_code (String employer_zip_code) {
    this.employer_zip_code = employer_zip_code;
  }

  public Boolean getDisable_sms_messages () {
    return disable_sms_messages;
  }

  public void setDisable_sms_messages (Boolean disable_sms_messages) {
    this.disable_sms_messages = disable_sms_messages;
  }

  public Integer getDoctor () {
    return doctor;
  }

  public void setDoctor (Integer doctor) {
    this.doctor = doctor;
  }

  public String getPrimary_care_physician () {
    return primary_care_physician;
  }

  public void setPrimary_care_physician (String primary_care_physician) {
    this.primary_care_physician = primary_care_physician;
  }

  public String getDate_of_first_appointment () {
    return date_of_first_appointment;
  }

  public void setDate_of_first_appointment (String date_of_first_appointment) {
    this.date_of_first_appointment = date_of_first_appointment;
  }

  public String getDate_of_last_appointment () {
    return date_of_last_appointment;
  }

  public void setDate_of_last_appointment (String date_of_last_appointment) {
    this.date_of_last_appointment = date_of_last_appointment;
  }

  public List<Integer> getOffices () {
    return offices;
  }

  public void setOffices (List<Integer> offices) {
    this.offices = offices;
  }

  public String getDefault_pharmacy () {
    return default_pharmacy;
  }

  public void setDefault_pharmacy (String default_pharmacy) {
    this.default_pharmacy = default_pharmacy;
  }

  public String getReferring_source () {
    return referring_source;
  }

  public void setReferring_source (String referring_source) {
    this.referring_source = referring_source;
  }

  public String getCopay () {
    return copay;
  }

  public void setCopay (String copay) {
    this.copay = copay;
  }

  public String getResponsible_party_name () {
    return responsible_party_name;
  }

  public void setResponsible_party_name (String responsible_party_name) {
    this.responsible_party_name = responsible_party_name;
  }

  public String getResponsible_party_relation () {
    return responsible_party_relation;
  }

  public void setResponsible_party_relation (String responsible_party_relation) {
    this.responsible_party_relation = responsible_party_relation;
  }

  public String getResponsible_party_phone () {
    return responsible_party_phone;
  }

  public void setResponsible_party_phone (String responsible_party_phone) {
    this.responsible_party_phone = responsible_party_phone;
  }

  public String getResponsible_party_email () {
    return responsible_party_email;
  }

  public void setResponsible_party_email (String responsible_party_email) {
    this.responsible_party_email = responsible_party_email;
  }

  public String getUpdated_at () {
    return updated_at;
  }

  public void setUpdated_at (String updated_at) {
    this.updated_at = updated_at;
  }

  @Override
  public String toString () {
    final StringBuilder sb = new StringBuilder("Patient{");
    sb.append("id=").append(id);
    sb.append(", chart_id='").append(chart_id).append('\'');
    sb.append(", first_name='").append(first_name).append('\'');
    sb.append(", middle_name='").append(middle_name).append('\'');
    sb.append(", last_name='").append(last_name).append('\'');
    sb.append(", nick_name='").append(nick_name).append('\'');
    sb.append(", date_of_birth='").append(date_of_birth).append('\'');
    sb.append(", gender='").append(gender).append('\'');
    sb.append(", social_security_number='").append(social_security_number).append('\'');
    sb.append(", race='").append(race).append('\'');
    sb.append(", ethnicity='").append(ethnicity).append('\'');
    sb.append(", preferred_language='").append(preferred_language).append('\'');
    sb.append(", patient_photo='").append(patient_photo).append('\'');
    sb.append(", patient_photo_date='").append(patient_photo_date).append('\'');
    sb.append(", patient_payment_profile='").append(patient_payment_profile).append('\'');
    sb.append(", patient_status='").append(patient_status).append('\'');
    sb.append(", home_phone='").append(home_phone).append('\'');
    sb.append(", cell_phone='").append(cell_phone).append('\'');
    sb.append(", office_phone='").append(office_phone).append('\'');
    sb.append(", email='").append(email).append('\'');
    sb.append(", address='").append(address).append('\'');
    sb.append(", city='").append(city).append('\'');
    sb.append(", state='").append(state).append('\'');
    sb.append(", zip_code='").append(zip_code).append('\'');
    sb.append(", emergency_contact_name='").append(emergency_contact_name).append('\'');
    sb.append(", emergency_contact_phone='").append(emergency_contact_phone).append('\'');
    sb.append(", emergency_contact_relation='").append(emergency_contact_relation).append('\'');
    sb.append(", employer='").append(employer).append('\'');
    sb.append(", employer_address='").append(employer_address).append('\'');
    sb.append(", employer_city='").append(employer_city).append('\'');
    sb.append(", employer_state='").append(employer_state).append('\'');
    sb.append(", employer_zip_code='").append(employer_zip_code).append('\'');
    sb.append(", disable_sms_messages=").append(disable_sms_messages);
    sb.append(", doctor=").append(doctor);
    sb.append(", primary_care_physician='").append(primary_care_physician).append('\'');
    sb.append(", date_of_first_appointment='").append(date_of_first_appointment).append('\'');
    sb.append(", date_of_last_appointment='").append(date_of_last_appointment).append('\'');
    sb.append(", offices=").append(offices);
    sb.append(", default_pharmacy='").append(default_pharmacy).append('\'');
    sb.append(", referring_source='").append(referring_source).append('\'');
    sb.append(", copay='").append(copay).append('\'');
    sb.append(", responsible_party_name='").append(responsible_party_name).append('\'');
    sb.append(", responsible_party_relation='").append(responsible_party_relation).append('\'');
    sb.append(", responsible_party_phone='").append(responsible_party_phone).append('\'');
    sb.append(", responsible_party_email='").append(responsible_party_email).append('\'');
    sb.append(", updated_at='").append(updated_at).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
