package com.uade.screenspace.models;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
* InlineResponse400
*/
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = ResetPasswordTokenError.class, name = "ResetPasswordTokenError"),
  @JsonSubTypes.Type(value = UpdatePasswordError.class, name = "UpdatePasswordError")
})
public interface InlineResponse400 {

}
