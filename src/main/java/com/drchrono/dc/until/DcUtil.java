package com.drchrono.dc.until;

import com.drchrono.dc.dto.OauthToken;
import com.drchrono.dc.dto.UserResponse;
import com.google.gson.JsonSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;

@Service
public class DcUtil {

  private static final Logger LOGGER = LoggerFactory.getLogger(DcUtil.class);


  @Autowired
  private WebSerivceCallsUtil webSerivceCallsUtil;
  @Value("${client.id}")
  private String clientID;
  @Value("${client.secret}")
  private String clientSecret;
  @Value("${refresh.token}")
  private String refreshToken;

  public String getAccessToken () {

    String accessTokeUrl =
        "https://drchrono.com/o/token/?grant_type=refresh_token&client_id=" + clientID
            + "&client_secret=" + clientSecret
            + "&redirect_uri=http://localhost:3000/&refresh_token="
            + refreshToken;
    String messageBody = null;
    OauthToken oauthToken = webSerivceCallsUtil
        .callWebServicePOST(accessTokeUrl, messageBody, OauthToken.class);

    return oauthToken.getAccess_token();
  }


  public UserResponse getPatientData (String getPatientURL) {

    while (true) {
      try {
        String accessToken = System.getProperty("accessToken");
        UserResponse userResponse = webSerivceCallsUtil
            .getPatientData(getPatientURL, accessToken);
        return userResponse;
      } catch (JsonSyntaxException ie) {
        LOGGER.error("JsonSyntaxException exception thrown: {}", ie.getMessage());
        String accessToken = getAccessToken();
        System.setProperty("accessToken", accessToken);
      } catch (Unauthorized ue) {
        LOGGER.error("Unauthorized exception thrown: {}", ue.getMessage());
        String accessToken = getAccessToken();
        System.setProperty("accessToken", accessToken);
      } catch (Exception e) {
        LOGGER.error("Exception thrown: {}", e.getMessage(), e);
        return null;
      }

    }

  }


}
