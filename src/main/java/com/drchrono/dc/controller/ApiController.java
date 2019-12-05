package com.drchrono.dc.controller;

import com.drchrono.dc.until.DcUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This Controller is for Swagger UI. DO NOT DELETE!
 */
@Api
@RestController
public class ApiController {

  @Autowired
  DcUtil dcUtil;

  @RequestMapping(value = "/ping", method = RequestMethod.GET)
  public String ping () {

    return "Working";

  }


  @RequestMapping(value = "/insertPatientData", method = RequestMethod.GET)
  public void insertPatientData () {
    dcUtil.insertPatient();

  }


  @RequestMapping(value = "/insertAppointmentData", method = RequestMethod.GET)
  public void insertAppointmentData () {
    dcUtil.insertAllAppointments();
  }

  @RequestMapping(value = "/insertMedicationData", method = RequestMethod.GET)
  public void insertMedicationData () {
    dcUtil.insertAllMedication();
  }

}
