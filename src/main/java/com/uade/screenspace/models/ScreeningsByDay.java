package com.uade.screenspace.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ScreeningsByDay
 */
@Validated

public class ScreeningsByDay   {
  @JsonProperty("date")
  private LocalDate date = null;

  @JsonProperty("screenings")
  @Valid
  private List<Screening> screenings = new ArrayList<Screening>();

  public ScreeningsByDay date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * The date of the movies.
   * @return date
   **/
  @Schema(required = true, description = "The date of the movies.")
      @NotNull

    @Valid
    public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public ScreeningsByDay screenings(List<Screening> screenings) {
    this.screenings = screenings;
    return this;
  }

  public ScreeningsByDay addScreeningsItem(Screening screeningsItem) {
    this.screenings.add(screeningsItem);
    return this;
  }

  /**
   * Get screenings
   * @return screenings
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<Screening> getScreenings() {
    return screenings;
  }

  public void setScreenings(List<Screening> screenings) {
    this.screenings = screenings;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScreeningsByDay screeningsByDay = (ScreeningsByDay) o;
    return Objects.equals(this.date, screeningsByDay.date) &&
        Objects.equals(this.screenings, screeningsByDay.screenings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, screenings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScreeningsByDay {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    screenings: ").append(toIndentedString(screenings)).append("\n");
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
