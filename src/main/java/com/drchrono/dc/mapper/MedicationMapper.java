package com.drchrono.dc.mapper;

import com.drchrono.dc.dto.Appointment;
import com.drchrono.dc.dto.Medication;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class MedicationMapper implements RowMapper<Medication> {

  @Override
  public Medication mapRow (ResultSet rs, int rowNum) throws SQLException {
    Medication medication = new Medication();

    medication.setId(rs.getInt("id"));
    medication.setDoctor(rs.getInt("doctor"));
    medication.setPatient(rs.getInt("patient"));
    medication.setAppointment(rs.getInt("appointment"));
    medication.setDate_prescribed(rs.getString("date_prescribed"));
    medication.setDate_started_taking(rs.getString("date_started_taking"));
    medication.setDate_stopped_taking(rs.getString("date_stopped_taking"));
    medication.setNotes(rs.getString("notes"));
    medication.setOrder_status(rs.getString("order_status"));
    medication.setNumber_refills(rs.getInt("number_refills"));
    medication.setDispense_quantity(rs.getString("dispense_quantity"));
    medication.setDosage_quantity(rs.getString("dosage_quantity"));
    medication.setDosage_units(rs.getString("dosage_units"));
    medication.setRxnorm(rs.getString("rxnorm"));
    medication.setRoute(rs.getString("route"));
    medication.setFrequency(rs.getString("frequency"));
    medication.setPrn(rs.getBoolean("prn"));
    medication.setIndication(rs.getString("indication"));
    medication.setSignature_note(rs.getString("signature_note"));
    medication.setPharmacy_note(rs.getString("pharmacy_note"));
    medication.setName(rs.getString("name"));
    medication.setStatus(rs.getString("status"));
    medication.setDaw(rs.getBoolean("daw"));


    return medication;
  }

}