package com.drchrono.dc.config;

import io.swagger.annotations.Api;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api () {
    return new Docket(DocumentationType.SWAGGER_2)
        .directModelSubstitute(XMLGregorianCalendar.class, String.class)
        .select()
        .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
        .paths(PathSelectors.ant("/**"))
        .build();
  }

}