package com.uade.screenspace.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.util.Objects;

/**
 * CreateScreeningRequest
 */
@Validated

public class CreateScreeningRequest   {
  @JsonProperty("movieId")
  private String movieId = null;

  @JsonProperty("theaterId")
  private String theaterId = null;

  @JsonProperty("date")
  private OffsetDateTime date = null;

  public CreateScreeningRequest movieId(String movieId) {
    this.movieId = movieId;
    return this;
  }

  /**
   * Id of movie
   * @return movieId
   **/
  @Schema(description = "Id of movie")
  
    public String getMovieId() {
    return movieId;
  }

  public void setMovieId(String movieId) {
    this.movieId = movieId;
  }

  public CreateScreeningRequest theaterId(String theaterId) {
    this.theaterId = theaterId;
    return this;
  }

  /**
   * Id of theater
   * @return theaterId
   **/
  @Schema(description = "Id of theater")
  
    public String getTheaterId() {
    return theaterId;
  }

  public void setTheaterId(String theaterId) {
    this.theaterId = theaterId;
  }

  public CreateScreeningRequest date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Date of the screening
   * @return date
   **/
  @Schema(description = "Date of the screening")
  
    @Valid
    public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateScreeningRequest createScreeningRequest = (CreateScreeningRequest) o;
    return Objects.equals(this.movieId, createScreeningRequest.movieId) &&
        Objects.equals(this.theaterId, createScreeningRequest.theaterId) &&
        Objects.equals(this.date, createScreeningRequest.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(movieId, theaterId, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateScreeningRequest {\n");
    
    sb.append("    movieId: ").append(toIndentedString(movieId)).append("\n");
    sb.append("    theaterId: ").append(toIndentedString(theaterId)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
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
