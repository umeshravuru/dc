package com.drchrono.dc.until;

import com.drchrono.dc.constants.SqlConstants;
import com.drchrono.dc.dto.User;
import com.drchrono.dc.dto.UserResponse;
import com.drchrono.dc.mapper.UserMapper;
import java.sql.Types;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PostgresUtl {

  private static final Logger LOGGER = LoggerFactory.getLogger(PostgresUtl.class);


  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Autowired
  DcUtil dcUtil;

  public void insertPatient () {
    LOGGER.info("Inside insertPatient method");

    Long startTime = System.currentTimeMillis();
    String getPatientURL = "https://drchrono.com/api/patients";
    while (true) {

      UserResponse userResponse = dcUtil.getPatientData(getPatientURL);

      int[] types = {Types.BIGINT, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
          Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
          Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
          Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
          Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
          Types.VARCHAR, Types.BIGINT, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
          Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
          Types.VARCHAR};

      for (User user : userResponse.getResults()) {
        Object[] params = {user.getId(), user.getChart_id(),
            user.getFirst_name(), user.getMiddle_name(), user.getLast_name(),
            user.getDate_of_birth(), user.getGender(),
            user.getSocial_security_number(),
            user.getRace(), user.getEthnicity(), user.getPatient_photo(),
            user.getPatient_payment_profile(), user.getPatient_status(),
            user.getHome_phone(), user.getCell_phone(), user.getOffice_phone(),
            user.getEmail(), user.getAddress(), user.getCity(), user.getState(),
            user.getZip_code(), user.getEmergency_contact_name(),
            user.getEmergency_contact_phone(), user.getEmergency_contact_relation(),
            user.getEmployer(), user.getEmployer_address(), user.getEmployer_city(),
            user.getEmployer_state(), user.getEmployer_zip_code(),
            user.getDisable_sms_messages(), user.getDoctor(),
            user.getPrimary_care_physician(), user.getDate_of_first_appointment(),
            user.getDate_of_last_appointment(), user.getDefault_pharmacy(),
            user.getReferring_source(), user.getCopay(),
            user.getResponsible_party_name(), user.getResponsible_party_relation(),
            user.getResponsible_party_phone(), user.getResponsible_party_email(),
            user.getUpdated_at()};

        List<User> usersFromDB = getUsers(user.getId());

        if (usersFromDB.get(0).getId() != null && usersFromDB.get(0).getId().intValue() != user
            .getId().intValue()) {
          jdbcTemplate.update(SqlConstants.insertUser, params, types);
        }

      }
      getPatientURL = userResponse.getNext();
      if (StringUtils.isEmpty(getPatientURL)) {
        LOGGER.info("Total time to insert userData is: {} seconds",
            (System.currentTimeMillis() - startTime) / 1000);
        LOGGER.info("Exiting from insertPatient method");
        break;
      }

    }
  }

  public List<User> getUsers (int userID) {
    MapSqlParameterSource selectUserParams = new MapSqlParameterSource();
    selectUserParams.addValue("ID", userID);
    LOGGER.info("Checking if the user {} already in the database id", userID);
    namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    return namedParameterJdbcTemplate
        .query(SqlConstants.getUser, selectUserParams,
            new UserMapper());
  }


}
