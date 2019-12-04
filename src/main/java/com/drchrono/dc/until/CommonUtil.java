package com.drchrono.dc.until;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class CommonUtil {


  private static final Logger LOGGER = LoggerFactory.getLogger(DcUtil.class);

  public Long getWaitTime () {
    LOGGER.info("Inside getWaitTime method");
    Long currentTime = System.currentTimeMillis();
    Long waitTime = 65 - ((currentTime % 3600000L) / 60000L);
    LOGGER.info("Wait time is - {}mins", waitTime);
    LOGGER.info("Exiting from getWaitTime method");
    return waitTime;
  }

}
