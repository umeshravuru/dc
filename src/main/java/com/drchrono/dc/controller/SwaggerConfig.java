package com.drchrono.dc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

public class SwaggerConfig {


  @RequestMapping(value = {"/", "/api"}, method = RequestMethod.GET)
  public @ResponseBody
  ModelAndView swaggerui () {

    return new ModelAndView("redirect:swagger-ui.html");
  }

}
