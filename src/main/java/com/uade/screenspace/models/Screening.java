package com.uade.screenspace.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Screening
 */
@Validated

public class Screening   {
  @JsonProperty("theater")
  private Theater theater = null;

  @JsonProperty("movie")
  @Valid
  private List<Movie> movie = null;

  @JsonProperty("seatsReserved")
  @Valid
  private List<SeatReserved> seatsReserved = null;

  @JsonProperty("date")
  private OffsetDateTime date = null;

  public Screening theater(Theater theater) {
    this.theater = theater;
    return this;
  }

  /**
   * Get theater
   * @return theater
   **/
  @Schema(description = "")
  
    @Valid
    public Theater getTheater() {
    return theater;
  }

  public void setTheater(Theater theater) {
    this.theater = theater;
  }

  public Screening movie(List<Movie> movie) {
    this.movie = movie;
    return this;
  }

  public Screening addMovieItem(Movie movieItem) {
    if (this.movie == null) {
      this.movie = new ArrayList<Movie>();
    }
    this.movie.add(movieItem);
    return this;
  }

  /**
   * Get movie
   * @return movie
   **/
  @Schema(description = "")
      @Valid
    public List<Movie> getMovie() {
    return movie;
  }

  public void setMovie(List<Movie> movie) {
    this.movie = movie;
  }

  public Screening seatsReserved(List<SeatReserved> seatsReserved) {
    this.seatsReserved = seatsReserved;
    return this;
  }

  public Screening addSeatsReservedItem(SeatReserved seatsReservedItem) {
    if (this.seatsReserved == null) {
      this.seatsReserved = new ArrayList<SeatReserved>();
    }
    this.seatsReserved.add(seatsReservedItem);
    return this;
  }

  /**
   * Get seatsReserved
   * @return seatsReserved
   **/
  @Schema(description = "")
      @Valid
    public List<SeatReserved> getSeatsReserved() {
    return seatsReserved;
  }

  public void setSeatsReserved(List<SeatReserved> seatsReserved) {
    this.seatsReserved = seatsReserved;
  }

  public Screening date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * date of screening
   * @return date
   **/
  @Schema(description = "date of screening")
  
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
    Screening screening = (Screening) o;
    return Objects.equals(this.theater, screening.theater) &&
        Objects.equals(this.movie, screening.movie) &&
        Objects.equals(this.seatsReserved, screening.seatsReserved) &&
        Objects.equals(this.date, screening.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(theater, movie, seatsReserved, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Screening {\n");
    
    sb.append("    theater: ").append(toIndentedString(theater)).append("\n");
    sb.append("    movie: ").append(toIndentedString(movie)).append("\n");
    sb.append("    seatsReserved: ").append(toIndentedString(seatsReserved)).append("\n");
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
