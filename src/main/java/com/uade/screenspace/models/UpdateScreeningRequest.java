package com.uade.screenspace.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.util.Objects;

/**
 * UpdateScreeningRequest
 */
@Validated

public class UpdateScreeningRequest   {
  @JsonProperty("movieId")
  private String movieId = null;

  @JsonProperty("theaterId")
  private String theaterId = null;

  @JsonProperty("date")
  private OffsetDateTime date = null;

  public UpdateScreeningRequest movieId(String movieId) {
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

  public UpdateScreeningRequest theaterId(String theaterId) {
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

  public UpdateScreeningRequest date(OffsetDateTime date) {
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
    UpdateScreeningRequest updateScreeningRequest = (UpdateScreeningRequest) o;
    return Objects.equals(this.movieId, updateScreeningRequest.movieId) &&
        Objects.equals(this.theaterId, updateScreeningRequest.theaterId) &&
        Objects.equals(this.date, updateScreeningRequest.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(movieId, theaterId, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateScreeningRequest {\n");
    
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
