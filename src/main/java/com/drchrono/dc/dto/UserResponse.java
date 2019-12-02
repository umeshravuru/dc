package com.drchrono.dc.dto;

import java.util.List;

public class UserResponse {

  private String previous;
  private List<User> results = null;
  private String next;

  public String getPrevious () {
    return previous;
  }

  public void setPrevious (String previous) {
    this.previous = previous;
  }

  public List<User> getResults () {
    return results;
  }

  public void setResults (List<User> results) {
    this.results = results;
  }

  public String getNext () {
    return next;
  }

  public void setNext (String next) {
    this.next = next;
  }

  @Override
  public String toString () {
    final StringBuilder sb = new StringBuilder("UserResponse{");
    sb.append("previous='").append(previous).append('\'');
    sb.append(", results=").append(results);
    sb.append(", next='").append(next).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
