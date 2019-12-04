package com.drchrono.dc.dto;

public class Medication {

  private Integer id;
  private Integer doctor;
  private Integer patient;
  private Integer appointment;
  private String date_prescribed;
  private String date_started_taking;
  private String date_stopped_taking;
  private String notes;
  private String order_status;
  private Integer number_refills;
  private String dispense_quantity;
  private String dosage_quantity;
  private String dosage_units;
  private String rxnorm;
  private String route;
  private String frequency;
  private Boolean prn;
  private String indication;
  private String signature_note;
  private String pharmacy_note;
  private String name;
  private String status;
  private Boolean daw;


  public Integer getId () {
    return id;
  }

  public void setId (Integer id) {
    this.id = id;
  }

  public Integer getDoctor () {
    return doctor;
  }

  public void setDoctor (Integer doctor) {
    this.doctor = doctor;
  }

  public Integer getPatient () {
    return patient;
  }

  public void setPatient (Integer patient) {
    this.patient = patient;
  }

  public Integer getAppointment () {
    return appointment;
  }

  public void setAppointment (Integer appointment) {
    this.appointment = appointment;
  }

  public String getDate_prescribed () {
    return date_prescribed;
  }

  public void setDate_prescribed (String date_prescribed) {
    this.date_prescribed = date_prescribed;
  }

  public String getDate_started_taking () {
    return date_started_taking;
  }

  public void setDate_started_taking (String date_started_taking) {
    this.date_started_taking = date_started_taking;
  }

  public String getDate_stopped_taking () {
    return date_stopped_taking;
  }

  public void setDate_stopped_taking (String date_stopped_taking) {
    this.date_stopped_taking = date_stopped_taking;
  }

  public String getNotes () {
    return notes;
  }

  public void setNotes (String notes) {
    this.notes = notes;
  }

  public String getOrder_status () {
    return order_status;
  }

  public void setOrder_status (String order_status) {
    this.order_status = order_status;
  }

  public Integer getNumber_refills () {
    return number_refills;
  }

  public void setNumber_refills (Integer number_refills) {
    this.number_refills = number_refills;
  }

  public String getDispense_quantity () {
    return dispense_quantity;
  }

  public void setDispense_quantity (String dispense_quantity) {
    this.dispense_quantity = dispense_quantity;
  }

  public String getDosage_quantity () {
    return dosage_quantity;
  }

  public void setDosage_quantity (String dosage_quantity) {
    this.dosage_quantity = dosage_quantity;
  }

  public String getDosage_units () {
    return dosage_units;
  }

  public void setDosage_units (String dosage_units) {
    this.dosage_units = dosage_units;
  }

  public String getRxnorm () {
    return rxnorm;
  }

  public void setRxnorm (String rxnorm) {
    this.rxnorm = rxnorm;
  }

  public String getRoute () {
    return route;
  }

  public void setRoute (String route) {
    this.route = route;
  }

  public String getFrequency () {
    return frequency;
  }

  public void setFrequency (String frequency) {
    this.frequency = frequency;
  }

  public Boolean getPrn () {
    return prn;
  }

  public void setPrn (Boolean prn) {
    this.prn = prn;
  }

  public String getIndication () {
    return indication;
  }

  public void setIndication (String indication) {
    this.indication = indication;
  }

  public String getSignature_note () {
    return signature_note;
  }

  public void setSignature_note (String signature_note) {
    this.signature_note = signature_note;
  }

  public String getPharmacy_note () {
    return pharmacy_note;
  }

  public void setPharmacy_note (String pharmacy_note) {
    this.pharmacy_note = pharmacy_note;
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public String getStatus () {
    return status;
  }

  public void setStatus (String status) {
    this.status = status;
  }

  public Boolean getDaw () {
    return daw;
  }

  public void setDaw (Boolean daw) {
    this.daw = daw;
  }


  @Override
  public String toString () {
    final StringBuilder sb = new StringBuilder("Medication{");
    sb.append("id=").append(id);
    sb.append(", doctor=").append(doctor);
    sb.append(", patient=").append(patient);
    sb.append(", appointment=").append(appointment);
    sb.append(", date_prescribed='").append(date_prescribed).append('\'');
    sb.append(", date_started_taking='").append(date_started_taking).append('\'');
    sb.append(", date_stopped_taking='").append(date_stopped_taking).append('\'');
    sb.append(", notes='").append(notes).append('\'');
    sb.append(", order_status='").append(order_status).append('\'');
    sb.append(", number_refills=").append(number_refills);
    sb.append(", dispense_quantity='").append(dispense_quantity).append('\'');
    sb.append(", dosage_quantity='").append(dosage_quantity).append('\'');
    sb.append(", dosage_units='").append(dosage_units).append('\'');
    sb.append(", rxnorm='").append(rxnorm).append('\'');
    sb.append(", route='").append(route).append('\'');
    sb.append(", frequency='").append(frequency).append('\'');
    sb.append(", prn=").append(prn);
    sb.append(", indication='").append(indication).append('\'');
    sb.append(", signature_note='").append(signature_note).append('\'');
    sb.append(", pharmacy_note='").append(pharmacy_note).append('\'');
    sb.append(", name='").append(name).append('\'');
    sb.append(", status='").append(status).append('\'');
    sb.append(", daw=").append(daw);
    sb.append('}');
    return sb.toString();
  }
}
