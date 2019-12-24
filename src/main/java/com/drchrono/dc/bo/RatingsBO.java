package com.drchrono.dc.bo;

import com.drchrono.dc.constants.SqlConstants;
import com.drchrono.dc.dto.Rating;
import java.sql.Types;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class RatingsBO {

  private static final Logger LOGGER = LoggerFactory.getLogger(RatingsBO.class);

  @Autowired
  JdbcTemplate jdbcTemplate;


  public void insertRating (Rating rating) {
    LOGGER.info("Inside insertRating method");

    Long startTime = System.currentTimeMillis();

    int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
        Types.VARCHAR, Types.VARCHAR,Types.BIGINT,Types.VARCHAR,Types.BIGINT,Types.VARCHAR,
        Types.BIGINT,Types.VARCHAR,Types.BIGINT,Types.VARCHAR,Types.BIGINT,Types.VARCHAR,
        Types.BIGINT,Types.VARCHAR,Types.BIGINT,Types.VARCHAR,Types.BIGINT,Types.VARCHAR,
        Types.BIGINT,Types.VARCHAR,Types.BIGINT,Types.VARCHAR,Types.BIGINT,Types.VARCHAR,
        Types.BIGINT,Types.VARCHAR,Types.BIGINT,Types.VARCHAR,Types.BIGINT,Types.VARCHAR,
        Types.BIGINT,Types.VARCHAR,Types.BIGINT,Types.VARCHAR,Types.BIGINT,Types.VARCHAR,
        Types.BIGINT,Types.VARCHAR,Types.BIGINT,Types.VARCHAR,Types.BIGINT,Types.VARCHAR,
        Types.BIGINT,Types.VARCHAR,Types.BIGINT,Types.VARCHAR,Types.BIGINT,Types.VARCHAR };

    Object[] params = {
        rating.getPatient(), rating.getProvider(), rating.getBirthday(), rating.getGender(),
        rating.getVisit(), rating.getChart(), rating.getCheck_in_info(),
        rating.getFallin_asleep_rating(), rating.getFallin_asleep_desc(),
        rating.getSleep_during_the_night_rating(), rating.getSleep_during_the_night_desc(),
        rating.getWaking_up_too_easily_rating(), rating.getWaking_up_too_easily_desc(),
        rating.getSleeping_too_much_rating(), rating.getSleeping_too_much_desc(),
        rating.getFeeling_sad_rating(), rating.getFeeling_sad_desc(),
        rating.getDecreased_appetite_rating(), rating.getDecreased_appetite_desc(),
        rating.getIncreased_appetite_rating(), rating.getIncreased_appetite_desc(),
        rating.getDecreased_weight_rating(), rating.getDecreased_weight_desc(),
        rating.getIncreased_weight_rating(), rating.getIncreased_weight_desc(),
        rating.getConcentration_decision_making_rating(),
        rating.getConcentration_decision_making_desc(), rating.getView_of_myself_rating(),
        rating.getView_of_myself_desc(), rating.getThoughts_of_death_or_suicide_rating(),
        rating.getThoughts_of_death_or_suicide_desc(), rating.getGeneral_interest_rating(),
        rating.getGeneral_interest_desc(), rating.getEnergy_level_rating(),
        rating.getEnergy_level_desc(), rating.getFeeling_slowed_down_rating(),
        rating.getFeeling_slowed_down_desc(), rating.getFeeling_restless_rating(),
        rating.getFeeling_restless_desc(), rating.getFeeling_nervous_rating(),
        rating.getFeeling_nervous_desc(), rating.getStop_worrying_rating(),
        rating.getStop_worrying_desc(), rating.getToo_worrying_rating(),
        rating.getToo_worrying_desc(), rating.getTrouble_relaxing_rating(),
        rating.getTrouble_relaxing_desc(), rating.getPsychomotor_rating(),
        rating.getPsychomotor_desc(), rating.getIrritable_rating(), rating.getIrritable_desc(),
        rating.getFear_rating(), rating.getFear_desc()
    };

    jdbcTemplate.update(SqlConstants.insertRating, params, types);

    LOGGER.info("Total time to insert rating is: {} seconds",
        (System.currentTimeMillis() - startTime) / 1000);
    LOGGER.info("Exiting from insertRating method");
  }

}