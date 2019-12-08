package com.drchrono.dc.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@RestController
public class SwaggerConfig {


  @RequestMapping(value = {"/", "/api"}, method = RequestMethod.GET)
  public @ResponseBody
  ModelAndView swaggerui () {

    return new ModelAndView("redirect:swagger-ui.html");
  }

}
