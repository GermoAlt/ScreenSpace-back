package com.uade.screenspace.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * Theater
 */
@Validated

public class Theater   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("seatsLayout")
  private SeatsLayout seatsLayout = null;

  @JsonProperty("isTemporarilyClosed")
  private Boolean isTemporarilyClosed = null;

  public Theater name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the theater
   * @return name
   **/
  @Schema(description = "Name of the theater")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Theater seatsLayout(SeatsLayout seatsLayout) {
    this.seatsLayout = seatsLayout;
    return this;
  }

  /**
   * Get seatsLayout
   * @return seatsLayout
   **/
  @Schema(description = "")
  
    @Valid
    public SeatsLayout getSeatsLayout() {
    return seatsLayout;
  }

  public void setSeatsLayout(SeatsLayout seatsLayout) {
    this.seatsLayout = seatsLayout;
  }

  public Theater isTemporarilyClosed(Boolean isTemporarilyClosed) {
    this.isTemporarilyClosed = isTemporarilyClosed;
    return this;
  }

  /**
   * Indicates if the theater is temporarily closed.
   * @return isTemporarilyClosed
   **/
  @Schema(description = "Indicates if the theater is temporarily closed.")
  
    public Boolean isIsTemporarilyClosed() {
    return isTemporarilyClosed;
  }

  public void setIsTemporarilyClosed(Boolean isTemporarilyClosed) {
    this.isTemporarilyClosed = isTemporarilyClosed;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Theater theater = (Theater) o;
    return Objects.equals(this.name, theater.name) &&
        Objects.equals(this.seatsLayout, theater.seatsLayout) &&
        Objects.equals(this.isTemporarilyClosed, theater.isTemporarilyClosed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, seatsLayout, isTemporarilyClosed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Theater {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    seatsLayout: ").append(toIndentedString(seatsLayout)).append("\n");
    sb.append("    isTemporarilyClosed: ").append(toIndentedString(isTemporarilyClosed)).append("\n");
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
