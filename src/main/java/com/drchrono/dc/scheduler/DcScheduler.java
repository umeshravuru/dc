package com.drchrono.dc.scheduler;

import com.drchrono.dc.until.DcUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DcScheduler {

  private static final Logger LOGGER = LoggerFactory.getLogger(DcScheduler.class);

  @Autowired
  DcUtil dcUtil;

  @Scheduled(cron = "0 0 2 * * *")
  public void insertAllData() {
    LOGGER.info("Inside insertAllData method");

    LOGGER.info("Inserting parinetData from scheduler");
    dcUtil.insertPatient();
    LOGGER.info("Done parinetData from scheduler");


    LOGGER.info("Inserting appointments from scheduler");
    dcUtil.insertAllAppointments();
    LOGGER.info("Done appointments from scheduler");


    LOGGER.info("Inserting medication from scheduler");
    dcUtil.insertAllMedication();
    LOGGER.info("Done medication from scheduler");



    LOGGER.info("Exiting from insertAllData method");
  }



}
