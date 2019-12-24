package com.drchrono.dc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.StringUtils;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.drchrono.dc")
@EnableSwagger2
@EnableScheduling
@EnableAutoConfiguration
public class DcApplication {

  public static void main (String[] args) {
    if (StringUtils.isEmpty(System.getProperty("spring.profiles.active"))) {
      System.setProperty("spring.profiles.active", "local");
    }
    SpringApplication.run(DcApplication.class, args);
  }

}

