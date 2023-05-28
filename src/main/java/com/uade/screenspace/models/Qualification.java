package com.uade.screenspace.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * Qualification
 */
@Validated

public class Qualification   {
  @JsonProperty("rating")
  private Rating rating = null;

  @JsonProperty("comment")
  private Comment comment = null;

  public Qualification rating(Rating rating) {
    this.rating = rating;
    return this;
  }

  /**
   * Get rating
   * @return rating
   **/
  @Schema(description = "")
  
    @Valid
    public Rating getRating() {
    return rating;
  }

  public void setRating(Rating rating) {
    this.rating = rating;
  }

  public Qualification comment(Comment comment) {
    this.comment = comment;
    return this;
  }

  /**
   * Get comment
   * @return comment
   **/
  @Schema(description = "")
  
    @Valid
    public Comment getComment() {
    return comment;
  }

  public void setComment(Comment comment) {
    this.comment = comment;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Qualification qualification = (Qualification) o;
    return Objects.equals(this.rating, qualification.rating) &&
        Objects.equals(this.comment, qualification.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rating, comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Qualification {\n");
    
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
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
