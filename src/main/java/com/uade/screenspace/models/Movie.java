package com.uade.screenspace.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Movie
 */
@Validated

public class Movie   {
  @JsonProperty("title")
  private String title = null;

  @JsonProperty("image")
  private String image = null;

  @JsonProperty("genre")
  private String genre = null;

  @JsonProperty("synopsis")
  private String synopsis = null;

  @JsonProperty("rating")
  private Double rating = null;

  public Movie title(String title) {
    this.title = title;
    return this;
  }

  /**
   * The title of the movie.
   * @return title
   **/
  @Schema(required = true, description = "The title of the movie.")
      @NotNull

    public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Movie image(String image) {
    this.image = image;
    return this;
  }

  /**
   * The URI of the image of the movie.
   * @return image
   **/
  @Schema(required = true, description = "The URI of the image of the movie.")
      @NotNull

    public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Movie genre(String genre) {
    this.genre = genre;
    return this;
  }

  /**
   * The genre of the movie.
   * @return genre
   **/
  @Schema(required = true, description = "The genre of the movie.")
      @NotNull

    public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public Movie synopsis(String synopsis) {
    this.synopsis = synopsis;
    return this;
  }

  /**
   * The synopsis of the movie.
   * @return synopsis
   **/
  @Schema(required = true, description = "The synopsis of the movie.")
      @NotNull

    public String getSynopsis() {
    return synopsis;
  }

  public void setSynopsis(String synopsis) {
    this.synopsis = synopsis;
  }

  public Movie rating(Double rating) {
    this.rating = rating;
    return this;
  }

  /**
   * The rating of the movie.
   * @return rating
   **/
  @Schema(required = true, description = "The rating of the movie.")
      @NotNull

    public Double getRating() {
    return rating;
  }

  public void setRating(Double rating) {
    this.rating = rating;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Movie movie = (Movie) o;
    return Objects.equals(this.title, movie.title) &&
        Objects.equals(this.image, movie.image) &&
        Objects.equals(this.genre, movie.genre) &&
        Objects.equals(this.synopsis, movie.synopsis) &&
        Objects.equals(this.rating, movie.rating);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, image, genre, synopsis, rating);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Movie {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    genre: ").append(toIndentedString(genre)).append("\n");
    sb.append("    synopsis: ").append(toIndentedString(synopsis)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
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
