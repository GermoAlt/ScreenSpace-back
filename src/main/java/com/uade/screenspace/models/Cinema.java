package com.uade.screenspace.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Cinema
 */
@Validated

public class Cinema   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("address")
  private Address address = null;

  @JsonProperty("geoLocation")
  private GeoLocation geoLocation = null;

  @JsonProperty("owner")
  private User owner = null;

  @JsonProperty("pricePerFunction")
  private Double pricePerFunction = null;

  @JsonProperty("screeningsByDay")
  @Valid
  private List<ScreeningsByDay> screeningsByDay = null;

  public Cinema name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the cinema.
   * @return name
   **/
  @Schema(required = true, description = "The name of the cinema.")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Cinema address(Address address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Cinema geoLocation(GeoLocation geoLocation) {
    this.geoLocation = geoLocation;
    return this;
  }

  /**
   * Get geoLocation
   * @return geoLocation
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public GeoLocation getGeoLocation() {
    return geoLocation;
  }

  public void setGeoLocation(GeoLocation geoLocation) {
    this.geoLocation = geoLocation;
  }

  public Cinema owner(User owner) {
    this.owner = owner;
    return this;
  }

  /**
   * Get owner
   * @return owner
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }

  public Cinema pricePerFunction(Double pricePerFunction) {
    this.pricePerFunction = pricePerFunction;
    return this;
  }

  /**
   * The price per function in the cinema.
   * @return pricePerFunction
   **/
  @Schema(required = true, description = "The price per function in the cinema.")
      @NotNull

    public Double getPricePerFunction() {
    return pricePerFunction;
  }

  public void setPricePerFunction(Double pricePerFunction) {
    this.pricePerFunction = pricePerFunction;
  }

  public Cinema screeningsByDay(List<ScreeningsByDay> screeningsByDay) {
    this.screeningsByDay = screeningsByDay;
    return this;
  }

  public Cinema addScreeningsByDayItem(ScreeningsByDay screeningsByDayItem) {
    if (this.screeningsByDay == null) {
      this.screeningsByDay = new ArrayList<ScreeningsByDay>();
    }
    this.screeningsByDay.add(screeningsByDayItem);
    return this;
  }

  /**
   * Get screeningsByDay
   * @return screeningsByDay
   **/
  @Schema(description = "")
      @Valid
    public List<ScreeningsByDay> getScreeningsByDay() {
    return screeningsByDay;
  }

  public void setScreeningsByDay(List<ScreeningsByDay> screeningsByDay) {
    this.screeningsByDay = screeningsByDay;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cinema cinema = (Cinema) o;
    return Objects.equals(this.name, cinema.name) &&
        Objects.equals(this.address, cinema.address) &&
        Objects.equals(this.geoLocation, cinema.geoLocation) &&
        Objects.equals(this.owner, cinema.owner) &&
        Objects.equals(this.pricePerFunction, cinema.pricePerFunction) &&
        Objects.equals(this.screeningsByDay, cinema.screeningsByDay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, geoLocation, owner, pricePerFunction, screeningsByDay);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cinema {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    geoLocation: ").append(toIndentedString(geoLocation)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    pricePerFunction: ").append(toIndentedString(pricePerFunction)).append("\n");
    sb.append("    screeningsByDay: ").append(toIndentedString(screeningsByDay)).append("\n");
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
