package com.drchrono.dc.controller;

import com.drchrono.dc.dto.Patient;
import com.drchrono.dc.until.DcUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class PatientController {

  @Autowired
  DcUtil dcUtil;

  @RequestMapping(value = "/getPatientFromDB", method = RequestMethod.GET)
  @ApiOperation(value = "getPatientFromDB", nickname = "getPatientFromDB")
  @ApiResponses(
      {@ApiResponse(code = 200, message = "SUCCESS", response = Patient.class),
          @ApiResponse(code = 500, message = "INTERNAL_ERROR", response = String.class)})
  public Patient getPatient (@RequestParam int patientID) {
    Patient patient = dcUtil.getPatientFromDB(patientID);
    return patient;

  }

  @RequestMapping(value = "/getLatestPatientUpdated", method = RequestMethod.GET)
  @ApiOperation(value = "getLatestPatientUpdated", nickname = "getLatestPatientUpdated")
  @ApiResponses(
      {@ApiResponse(code = 200, message = "SUCCESS", response = Patient.class),
          @ApiResponse(code = 500, message = "INTERNAL_ERROR", response = String.class)})
  public Patient getLatestPatientUpdated () {
    Patient patient = dcUtil.getLatestPatientUpdated();
    return patient;

  }

}
