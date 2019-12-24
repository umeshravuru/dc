package com.drchrono.dc.controller;

import com.drchrono.dc.bo.RatingsBO;
import com.drchrono.dc.dto.Patient;
import com.drchrono.dc.dto.Rating;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class RatingsController {

  @Autowired
  RatingsBO ratingsBO;

  @RequestMapping(value = "/insertRating", method = RequestMethod.POST)
  @ApiOperation(value = "insertRating", nickname = "insertRating")
  @ApiResponses(
      {@ApiResponse(code = 200, message = "SUCCESS", response = Patient.class),
          @ApiResponse(code = 500, message = "INTERNAL_ERROR", response = String.class)})
  public void insertRating (@RequestBody Rating rating) {
    ratingsBO.insertRating(rating);
  }

}
