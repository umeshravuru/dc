package com.drchrono.dc.until;

import com.drchrono.dc.constants.SqlConstants;
import com.drchrono.dc.dto.Appointment;
import com.drchrono.dc.dto.AppointmentsResponse;
import com.drchrono.dc.dto.Medication;
import com.drchrono.dc.dto.MedicationResponse;
import com.drchrono.dc.dto.OauthToken;
import com.drchrono.dc.dto.Patient;
import com.drchrono.dc.dto.PatientResponse;
import com.drchrono.dc.mapper.AppointmentMapper;
import com.drchrono.dc.mapper.MedicationMapper;
import com.drchrono.dc.mapper.PatientIDMapper;
import com.drchrono.dc.mapper.PatientMapper;
import com.google.gson.JsonSyntaxException;
import java.sql.Types;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;

@Service
public class DcUtil {

  private static final Logger LOGGER = LoggerFactory.getLogger(DcUtil.class);
  @Autowired
  JdbcTemplate jdbcTemplate;
  @Autowired
  NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  @Autowired
  private WebSerivceCallsUtil webSerivceCallsUtil;
  @Value("${client.id}")
  private String clientID;
  @Value("${client.secret}")
  private String clientSecret;
  @Value("${refresh.token}")
  private String refreshToken;

  public String getAccessToken () {

    String accessTokeUrl =
        "https://drchrono.com/o/token/?grant_type=refresh_token&client_id=" + clientID
            + "&client_secret=" + clientSecret
            + "&redirect_uri=http://localhost:3000/&refresh_token="
            + refreshToken;
    String messageBody = null;
    OauthToken oauthToken = webSerivceCallsUtil
        .callWebServicePOST(accessTokeUrl, messageBody, OauthToken.class);

    return oauthToken.getAccess_token();
  }


  public PatientResponse getPatientData (String getPatientURL) {

    while (true) {
      try {
        String accessToken = System.getProperty("accessToken");
        PatientResponse patientResponse = webSerivceCallsUtil
            .callWebServiceGet(getPatientURL, accessToken, PatientResponse.class);
        return patientResponse;
      } catch (JsonSyntaxException ie) {
        LOGGER.error("JsonSyntaxException exception thrown: {}", ie.getMessage());
        LOGGER.error("Checking to see the ");
        String accessToken = getAccessToken();
        System.setProperty("accessToken", accessToken);
      } catch (Unauthorized ue) {
        LOGGER.error("Unauthorized exception thrown: {}", ue.getMessage());
        String accessToken = getAccessToken();
        System.setProperty("accessToken", accessToken);
      } catch (Exception e) {
        LOGGER.error("Exception thrown: {}", e.getMessage(), e);
        return null;
      }

    }

  }


  public void insertPatient () {
    LOGGER.info("Inside insertPatient method");

    Long startTime = System.currentTimeMillis();
    String getPatientURL = "https://drchrono.com/api/patients";
    while (true) {

      PatientResponse patientResponse = getPatientData(getPatientURL);

      int[] types = {Types.BIGINT, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
          Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
          Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
          Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
          Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
          Types.VARCHAR, Types.BIGINT, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
          Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
          Types.VARCHAR};

      for (Patient patient : patientResponse.getResults()) {
        Object[] params = {patient.getId(), patient.getChart_id(),
            patient.getFirst_name(), patient.getMiddle_name(), patient.getLast_name(),
            patient.getDate_of_birth(), patient.getGender(),
            patient.getSocial_security_number(),
            patient.getRace(), patient.getEthnicity(), patient.getPatient_photo(),
            patient.getPatient_payment_profile(), patient.getPatient_status(),
            patient.getHome_phone(), patient.getCell_phone(), patient.getOffice_phone(),
            patient.getEmail(), patient.getAddress(), patient.getCity(), patient.getState(),
            patient.getZip_code(), patient.getEmergency_contact_name(),
            patient.getEmergency_contact_phone(), patient.getEmergency_contact_relation(),
            patient.getEmployer(), patient.getEmployer_address(), patient.getEmployer_city(),
            patient.getEmployer_state(), patient.getEmployer_zip_code(),
            patient.getDisable_sms_messages(), patient.getDoctor(),
            patient.getPrimary_care_physician(), patient.getDate_of_first_appointment(),
            patient.getDate_of_last_appointment(), patient.getDefault_pharmacy(),
            patient.getReferring_source(), patient.getCopay(),
            patient.getResponsible_party_name(), patient.getResponsible_party_relation(),
            patient.getResponsible_party_phone(), patient.getResponsible_party_email(),
            patient.getUpdated_at()};

        Patient patientFromDB = getPatientFromDB(patient.getId());

        if (patientFromDB == null || patientFromDB.getId() == null) {
          LOGGER.info("Patient {} is not in the database, so Inserting into database.",
              patient.getId());
          jdbcTemplate.update(SqlConstants.insertPatient, params, types);
        }

        insertAppointments(String.valueOf(patient.getId()));

      }
      getPatientURL = patientResponse.getNext();
      if (StringUtils.isEmpty(getPatientURL)) {
        LOGGER.info("Total time to insert patientData is: {} seconds",
            (System.currentTimeMillis() - startTime) / 1000);
        LOGGER.info("Exiting from insertPatient method");
        break;
      }

    }
  }

  public Patient getPatientFromDB (int patientID) {
    MapSqlParameterSource selectPatientParams = new MapSqlParameterSource();
    selectPatientParams.addValue("ID", patientID);
    LOGGER.info("Getting patient {} from the database id", patientID);
    namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    List<Patient> patients = namedParameterJdbcTemplate
        .query(SqlConstants.getPatient, selectPatientParams,
            new PatientMapper());
    if (patients.size() > 0) {
      return patients.get(0);
    } else {
      return null;
    }
  }


  public AppointmentsResponse getAppointments (String getAppointmentsURL) {

    while (true) {
      try {
        String accessToken = System.getProperty("accessToken");
        AppointmentsResponse appointmentsResponse = webSerivceCallsUtil
            .callWebServiceGet(getAppointmentsURL, accessToken, AppointmentsResponse.class);
        return appointmentsResponse;
      } catch (JsonSyntaxException ie) {
        LOGGER.error("JsonSyntaxException exception thrown: {}", ie.getMessage());
        String accessToken = getAccessToken();
        System.setProperty("accessToken", accessToken);
      } catch (Unauthorized ue) {
        LOGGER.error("Unauthorized exception thrown: {}", ue.getMessage());
        String accessToken = getAccessToken();
        System.setProperty("accessToken", accessToken);
      } catch (Exception e) {
        LOGGER.error("Exception thrown: {}", e.getMessage(), e);
        return null;
      }

    }

  }


  public MedicationResponse getMedications (String medicationURL) {

    while (true) {
      try {
        String accessToken = System.getProperty("accessToken");
        MedicationResponse medicationResponse = webSerivceCallsUtil
            .callWebServiceGet(medicationURL, accessToken, MedicationResponse.class);
        return medicationResponse;
      } catch (JsonSyntaxException ie) {
        LOGGER.error("JsonSyntaxException exception thrown: {}", ie.getMessage());
        String accessToken = getAccessToken();
        System.setProperty("accessToken", accessToken);
      } catch (Unauthorized ue) {
        LOGGER.error("Unauthorized exception thrown: {}", ue.getMessage());
        String accessToken = getAccessToken();
        System.setProperty("accessToken", accessToken);
      } catch (Exception e) {
        LOGGER.error("Exception thrown: {}", e.getMessage(), e);
        return null;
      }

    }

  }


  public void insertAllMedication () {
    List<String> patientIds = getAllPatientIDs();
    for (String patinetID : patientIds) {
      insertMedication(patinetID);
    }
  }

  public void insertAllAppointments () {
    List<String> patientIds = getAllPatientIDs();
    for (String patinetID : patientIds) {
      insertAppointments(patinetID);
    }
  }

  public List<String> getAllPatientIDs () {
    return jdbcTemplate.query(SqlConstants.getAllPatientIds, new PatientIDMapper());
  }


  public void insertAppointments (String patientID) {
    LOGGER.info("Inside insertAppointments method");

    Long startTime = System.currentTimeMillis();
    String getAppointmentURL =
        "https://drchrono.com/api/appointments?since=1014-02-24&patient=" + patientID;
    while (true) {

      AppointmentsResponse appointmentsResponse = getAppointments(getAppointmentURL);

      int[] types = {Types.VARCHAR, Types.BOOLEAN, Types.BOOLEAN, Types.BIGINT, Types.VARCHAR,
          Types.VARCHAR, Types.BOOLEAN, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BOOLEAN,
          Types.VARCHAR, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.VARCHAR, Types.BOOLEAN,
          Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};

      for (Appointment appointment : appointmentsResponse.getResults()) {
        Object[] params = {appointment.getId(),
            appointment.getAllow_overlapping(),
            appointment.getAppt_is_break(),
            appointment.getBase_recurring_appointment(),
            appointment.getColor(),
            appointment.getCreated_at(),
            appointment.getDeleted_flag(),
            appointment.getDoctor(),
            appointment.getDuration(),
            appointment.getExam_room(),
            appointment.getIs_walk_in(),
            appointment.getNotes(),
            appointment.getOffice(),
            appointment.getPatient(),
            appointment.getProfile(),
            appointment.getReason(),
            appointment.getRecurring_appointment(),
            appointment.getScheduled_time(),
            appointment.getStatus(),
            appointment.getUpdated_at()};

        Appointment appointmentFromDB = getAppointment(appointment.getId());

        if (appointmentFromDB == null || appointmentFromDB.getId() == null) {
          LOGGER.info("Appointment {} is not in the database, so Inserting into database.",
              appointment.getId());
          jdbcTemplate.update(SqlConstants.insertAppointment, params, types);
        }

      }
      getAppointmentURL = appointmentsResponse.getNext();
      if (StringUtils.isEmpty(getAppointmentURL)) {
        LOGGER.info("Total time to insert appointments is: {} seconds",
            (System.currentTimeMillis() - startTime) / 1000);
        LOGGER.info("Exiting from insertAppointments method");
        break;
      }

    }
  }

  public Appointment getAppointment (String appointmentID) {
    MapSqlParameterSource selectAppointmentParams = new MapSqlParameterSource();
    selectAppointmentParams.addValue("appointmentid", appointmentID);
    LOGGER.info("Getting appointments {} from the database", appointmentID);
    namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    List<Appointment> appointments = namedParameterJdbcTemplate
        .query(SqlConstants.getAppointment, selectAppointmentParams,
            new AppointmentMapper());
    if (appointments.size() > 0) {
      return appointments.get(0);
    } else {
      return null;
    }
  }


  public void insertMedication (String patientID) {
    LOGGER.info("Inside insertMedication method");

    Long startTime = System.currentTimeMillis();
    String getMedicationURL =
        "https://drchrono.com/api/medications?patient=" + patientID;
    while (true) {

      MedicationResponse medicationResponse = getMedications(getMedicationURL);

      int[] types = {
          Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.VARCHAR,
          Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER,
          Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
          Types.VARCHAR, Types.BOOLEAN, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
          Types.VARCHAR, Types.VARCHAR, Types.BOOLEAN
      };

      for (Medication medication : medicationResponse.getResults()) {
        Object[] params = {
            medication.getId(),
            medication.getDoctor(),
            medication.getPatient(),
            medication.getAppointment(),
            medication.getDate_prescribed(),
            medication.getDate_started_taking(),
            medication.getDate_stopped_taking(),
            medication.getNotes(),
            medication.getOrder_status(),
            medication.getNumber_refills(),
            medication.getDispense_quantity(),
            medication.getDosage_quantity(),
            medication.getDosage_units(),
            medication.getRxnorm(),
            medication.getRoute(),
            medication.getFrequency(),
            medication.getPrn(),
            medication.getIndication(),
            medication.getSignature_note(),
            medication.getPharmacy_note(),
            medication.getName(),
            medication.getStatus(),
            medication.getDaw()
        };

        Medication medicationFromDB = getMedication(medication.getId());

        if (medicationFromDB == null || medicationFromDB.getId() == null) {
          LOGGER.info("Appointment {} is not in the database, so Inserting into database.",
              medication.getId());
          jdbcTemplate.update(SqlConstants.insertMedication, params, types);
        }

      }
      getMedicationURL = medicationResponse.getNext();
      if (StringUtils.isEmpty(getMedicationURL)) {
        LOGGER.info("Total time to insert medications is: {} seconds",
            (System.currentTimeMillis() - startTime) / 1000);
        LOGGER.info("Exiting from insertMedication method");
        break;
      }

    }
  }

  public Medication getMedication (int medicationID) {
    MapSqlParameterSource selectMedicationParams = new MapSqlParameterSource();
    selectMedicationParams.addValue("id", medicationID);
    LOGGER.info("Getting medication {} from the database", medicationID);
    namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    List<Medication> medications = namedParameterJdbcTemplate
        .query(SqlConstants.getMedication, selectMedicationParams,
            new MedicationMapper());
    if (medications.size() > 0) {
      return medications.get(0);
    } else {
      return null;
    }
  }


}
