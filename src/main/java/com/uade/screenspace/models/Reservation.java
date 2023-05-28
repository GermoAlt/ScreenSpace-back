package com.uade.screenspace.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Reservation
 */
@Validated

public class Reservation   {
  @JsonProperty("code")
  private BigDecimal code = null;

  @JsonProperty("cinema")
  private Cinema cinema = null;

  @JsonProperty("screening")
  private Screening screening = null;

  @JsonProperty("user")
  private User user = null;

  @JsonProperty("seatsReserved")
  @Valid
  private List<SeatReserved> seatsReserved = new ArrayList<SeatReserved>();

  public Reservation code(BigDecimal code) {
    this.code = code;
    return this;
  }

  /**
   * reservation code
   * @return code
   **/
  @Schema(description = "reservation code")
  
    @Valid
    public BigDecimal getCode() {
    return code;
  }

  public void setCode(BigDecimal code) {
    this.code = code;
  }

  public Reservation cinema(Cinema cinema) {
    this.cinema = cinema;
    return this;
  }

  /**
   * Get cinema
   * @return cinema
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Cinema getCinema() {
    return cinema;
  }

  public void setCinema(Cinema cinema) {
    this.cinema = cinema;
  }

  public Reservation screening(Screening screening) {
    this.screening = screening;
    return this;
  }

  /**
   * Get screening
   * @return screening
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Screening getScreening() {
    return screening;
  }

  public void setScreening(Screening screening) {
    this.screening = screening;
  }

  public Reservation user(User user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Reservation seatsReserved(List<SeatReserved> seatsReserved) {
    this.seatsReserved = seatsReserved;
    return this;
  }

  public Reservation addSeatsReservedItem(SeatReserved seatsReservedItem) {
    this.seatsReserved.add(seatsReservedItem);
    return this;
  }

  /**
   * Get seatsReserved
   * @return seatsReserved
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<SeatReserved> getSeatsReserved() {
    return seatsReserved;
  }

  public void setSeatsReserved(List<SeatReserved> seatsReserved) {
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
    Reservation reservation = (Reservation) o;
    return Objects.equals(this.code, reservation.code) &&
        Objects.equals(this.cinema, reservation.cinema) &&
        Objects.equals(this.screening, reservation.screening) &&
        Objects.equals(this.user, reservation.user) &&
        Objects.equals(this.seatsReserved, reservation.seatsReserved);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, cinema, screening, user, seatsReserved);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reservation {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    cinema: ").append(toIndentedString(cinema)).append("\n");
    sb.append("    screening: ").append(toIndentedString(screening)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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
