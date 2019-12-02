package com.drchrono.dc.controller;

import com.drchrono.dc.until.DcUtil;
import com.drchrono.dc.until.PostgresUtl;
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

  @Autowired
  PostgresUtl postgresUtl;

  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public void test () {
    postgresUtl.insertPatient();

  }

}
