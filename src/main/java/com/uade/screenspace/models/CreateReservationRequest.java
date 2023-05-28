package com.uade.screenspace.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * CreateReservationRequest
 */
@Validated


public class CreateReservationRequest   {
  @JsonProperty("cinemaId")
  private String cinemaId = null;

  @JsonProperty("screeningId")
  private String screeningId = null;

  @JsonProperty("seatsReserved")
  private SeatReserved seatsReserved = null;

  public CreateReservationRequest cinemaId(String cinemaId) {
    this.cinemaId = cinemaId;
    return this;
  }

  /**
   * Id of cinema
   * @return cinemaId
   **/
  @Schema(description = "Id of cinema")
  
    public String getCinemaId() {
    return cinemaId;
  }

  public void setCinemaId(String cinemaId) {
    this.cinemaId = cinemaId;
  }

  public CreateReservationRequest screeningId(String screeningId) {
    this.screeningId = screeningId;
    return this;
  }

  /**
   * Id of screening
   * @return screeningId
   **/
  @Schema(description = "Id of screening")
  
    public String getScreeningId() {
    return screeningId;
  }

  public void setScreeningId(String screeningId) {
    this.screeningId = screeningId;
  }

  public CreateReservationRequest seatsReserved(SeatReserved seatsReserved) {
    this.seatsReserved = seatsReserved;
    return this;
  }

  /**
   * Get seatsReserved
   * @return seatsReserved
   **/
  @Schema(description = "")
  
    @Valid
    public SeatReserved getSeatsReserved() {
    return seatsReserved;
  }

  public void setSeatsReserved(SeatReserved seatsReserved) {
    this.seatsReserved = seatsReserved;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateReservationRequest createReservationRequest = (CreateReservationRequest) o;
    return Objects.equals(this.cinemaId, createReservationRequest.cinemaId) &&
        Objects.equals(this.screeningId, createReservationRequest.screeningId) &&
        Objects.equals(this.seatsReserved, createReservationRequest.seatsReserved);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cinemaId, screeningId, seatsReserved);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateReservationRequest {\n");
    
    sb.append("    cinemaId: ").append(toIndentedString(cinemaId)).append("\n");
    sb.append("    screeningId: ").append(toIndentedString(screeningId)).append("\n");
    sb.append("    seatsReserved: ").append(toIndentedString(seatsReserved)).append("\n");
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
