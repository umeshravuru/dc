package com.drchrono.dc.until;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.client.RestTemplate;

@Component
public class WebSerivceCallsUtil {

  private static final Logger LOGGER = LoggerFactory.getLogger(WebSerivceCallsUtil.class);

  @Autowired
  CommonUtil commonUtil;

  public <T> T callWebServicePOST (String webServiceURL, String messageBody,
      Class<T> classToBeReturned) {
    LOGGER.info("Calling POST: {}", webServiceURL);
    LOGGER.info("With message body: {}", messageBody);

    RestTemplate restTemplate = new RestTemplate();
    T webServiceResponse;
    try {
      MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
      headers.add("Content-Type", MediaType.APPLICATION_XML_VALUE);

      HttpEntity<String> request = new HttpEntity<String>(messageBody, headers);

      webServiceResponse = (T) restTemplate
          .postForObject(webServiceURL, request, classToBeReturned);

    } catch (Exception e) {
      LOGGER.error("Error calling POST:" + webServiceURL + ", Message=" + e.getMessage());
      throw e;
    }
    return webServiceResponse;
  }


  public <T> T callWebServiceGet (String webServiceURL, String accessToke,
      Class<T> classToBeReturned) throws Unauthorized {
    LOGGER.trace("callWebServiceGET - Enter");
    LOGGER.info("Calling URL :: " + webServiceURL);
    try {

      HttpResponse<String> response = Unirest.get(webServiceURL)
          .header("Authorization", "Bearer " + accessToke)
          .asString();
      if (response.getStatus() == 429) {
        LOGGER.info("Quota limit exceeded. {}", response.getBody());
        Long waitTime = commonUtil.getWaitTime();
        LOGGER.info("Sleeping for {}mins", waitTime);
        Thread.sleep(waitTime * 60 * 1000);
        LOGGER.info("Done sleeping for {}mins", waitTime);
        throw new JsonSyntaxException("");
      }
      T webServiceResponse = new Gson().fromJson(response.getBody(), classToBeReturned);
      return webServiceResponse;
    } catch (JsonSyntaxException ie) {
      LOGGER.error("JsonSyntaxException exception thrown: {}", ie.getMessage());
      throw ie;
    } catch (Unauthorized ue) {
      LOGGER.error("Unauthorized exception thrown: {}", ue.getMessage());
      throw ue;
    } catch (Exception e) {
      LOGGER.error("Error while calling get webservice ; {}", e.getMessage(), e);
      return null;
    }

  }


}
