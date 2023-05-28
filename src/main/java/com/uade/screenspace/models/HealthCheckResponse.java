package com.uade.screenspace.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * HealthCheckResponse
 */
@Validated

public class HealthCheckResponse   {
  @JsonProperty("status")
  private String status = null;

  @JsonProperty("details")
  private Object details = null;

  public HealthCheckResponse status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Status of the server
   * @return status
   **/
  @Schema(description = "Status of the server")
  
    public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public HealthCheckResponse details(Object details) {
    this.details = details;
    return this;
  }

  /**
   * Additional details about the server's status
   * @return details
   **/
  @Schema(description = "Additional details about the server's status")
  
    public Object getDetails() {
    return details;
  }

  public void setDetails(Object details) {
    this.details = details;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HealthCheckResponse healthCheckResponse = (HealthCheckResponse) o;
    return Objects.equals(this.status, healthCheckResponse.status) &&
        Objects.equals(this.details, healthCheckResponse.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HealthCheckResponse {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
