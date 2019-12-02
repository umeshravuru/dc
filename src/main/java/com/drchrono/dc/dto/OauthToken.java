package com.drchrono.dc.dto;

public class OauthToken {

  private String access_token;
  private String token_type;
  private int expires_in;
  private String refresh_token;
  private String scope;


  public String getAccess_token () {
    return access_token;
  }

  public void setAccess_token (String access_token) {
    this.access_token = access_token;
  }

  public String getToken_type () {
    return token_type;
  }

  public void setToken_type (String token_type) {
    this.token_type = token_type;
  }

  public int getExpires_in () {
    return expires_in;
  }

  public void setExpires_in (int expires_in) {
    this.expires_in = expires_in;
  }

  public String getRefresh_token () {
    return refresh_token;
  }

  public void setRefresh_token (String refresh_token) {
    this.refresh_token = refresh_token;
  }

  public String getScope () {
    return scope;
  }

  public void setScope (String scope) {
    this.scope = scope;
  }

  @Override
  public String toString () {
    final StringBuilder sb = new StringBuilder("OauthToken{");
    sb.append("access_token='").append(access_token).append('\'');
    sb.append(", token_type='").append(token_type).append('\'');
    sb.append(", expires_in=").append(expires_in);
    sb.append(", refresh_token='").append(refresh_token).append('\'');
    sb.append(", scope='").append(scope).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
