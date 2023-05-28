package com.uade.screenspace.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Address
 */
@Validated

public class Address   {
  @JsonProperty("street")
  private String street = null;

  @JsonProperty("number")
  private String number = null;

  @JsonProperty("neighborhood")
  private String neighborhood = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("province")
  private String province = null;

  @JsonProperty("country")
  private String country = null;

  public Address street(String street) {
    this.street = street;
    return this;
  }

  /**
   * The street of the address.
   * @return street
   **/
  @Schema(required = true, description = "The street of the address.")
      @NotNull

    public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public Address number(String number) {
    this.number = number;
    return this;
  }

  /**
   * The number of the address.
   * @return number
   **/
  @Schema(required = true, description = "The number of the address.")
      @NotNull

    public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Address neighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
    return this;
  }

  /**
   * The neighborhood of the address.
   * @return neighborhood
   **/
  @Schema(required = true, description = "The neighborhood of the address.")
      @NotNull

    public String getNeighborhood() {
    return neighborhood;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }

  public Address city(String city) {
    this.city = city;
    return this;
  }

  /**
   * The city of the address.
   * @return city
   **/
  @Schema(required = true, description = "The city of the address.")
      @NotNull

    public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Address province(String province) {
    this.province = province;
    return this;
  }

  /**
   * The province of the address.
   * @return province
   **/
  @Schema(required = true, description = "The province of the address.")
      @NotNull

    public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public Address country(String country) {
    this.country = country;
    return this;
  }

  /**
   * The country of the address.
   * @return country
   **/
  @Schema(required = true, description = "The country of the address.")
      @NotNull

    public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(this.street, address.street) &&
        Objects.equals(this.number, address.number) &&
        Objects.equals(this.neighborhood, address.neighborhood) &&
        Objects.equals(this.city, address.city) &&
        Objects.equals(this.province, address.province) &&
        Objects.equals(this.country, address.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(street, number, neighborhood, city, province, country);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    neighborhood: ").append(toIndentedString(neighborhood)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    province: ").append(toIndentedString(province)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
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
