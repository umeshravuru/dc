package com.drchrono.dc.dto;

public class ThrottledDTO {

  private String detail;

  public String getDetail () {
    return detail;
  }

  public void setDetail (String detail) {
    this.detail = detail;
  }

  @Override
  public String toString () {
    final StringBuilder sb = new StringBuilder("ThrottledDTO{");
    sb.append("detail='").append(detail).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
