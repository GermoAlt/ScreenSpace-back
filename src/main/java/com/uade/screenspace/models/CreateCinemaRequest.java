package com.uade.screenspace.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * CreateCinemaRequest
 */
@Validated

public class CreateCinemaRequest   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("address")
  private Address address = null;

  @JsonProperty("geoLocation")
  private GeoLocation geoLocation = null;

  @JsonProperty("pricePerFunction")
  private Double pricePerFunction = null;

  public CreateCinemaRequest name(String name) {
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

  public CreateCinemaRequest address(Address address) {
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

  public CreateCinemaRequest geoLocation(GeoLocation geoLocation) {
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

  public CreateCinemaRequest pricePerFunction(Double pricePerFunction) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCinemaRequest createCinemaRequest = (CreateCinemaRequest) o;
    return Objects.equals(this.name, createCinemaRequest.name) &&
        Objects.equals(this.address, createCinemaRequest.address) &&
        Objects.equals(this.geoLocation, createCinemaRequest.geoLocation) &&
        Objects.equals(this.pricePerFunction, createCinemaRequest.pricePerFunction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, geoLocation, pricePerFunction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCinemaRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    geoLocation: ").append(toIndentedString(geoLocation)).append("\n");
    sb.append("    pricePerFunction: ").append(toIndentedString(pricePerFunction)).append("\n");
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
