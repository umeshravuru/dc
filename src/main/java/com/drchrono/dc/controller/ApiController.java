package com.drchrono.dc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * This Controller is for Swagger UI. DO NOT DELETE!
 */
@RestController
public class ApiController {


  /**
   * This mapping is used to redirect calls to "/api" to Swagger
   *
   * @return
   */
  @RequestMapping(value = "/api", method = RequestMethod.GET)
  public ModelAndView getApiInfo() {
    return new ModelAndView("redirect:/swagger-ui.html");
  }
}
