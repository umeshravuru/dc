package com.drchrono.dc.controller;

import com.drchrono.dc.dto.User;
import com.drchrono.dc.until.PostgresUtl;
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
@RestController(value = "/v1")
public class PatientController {

  @Autowired
  PostgresUtl postgresUtl;

  @RequestMapping(value = "/getPatient", method = RequestMethod.GET)
  @ApiOperation(value = "getPatient", nickname = "getPatient")
  @ApiResponses(
      {@ApiResponse(code = 200, message = "SUCCESS", response = User.class),
          @ApiResponse(code = 500, message = "INTERNAL_ERROR", response = String.class)})
  public void getPatient (@RequestParam int patientID) {
    postgresUtl.getUsers(patientID);

  }

}
