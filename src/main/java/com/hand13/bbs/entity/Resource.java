package com.hand13.bbs.entity;


import org.apache.commons.lang3.builder.ToStringBuilder;

public class Resource {

  private Integer resourceId;


  public Integer getResourceId() {
    return resourceId;
  }

  public void setResourceId(Integer resourceId) {
    this.resourceId = resourceId;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
