package com.uade.screenspace.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * SeatsLayout
 */
@Validated

public class SeatsLayout   {
  @JsonProperty("numRows")
  private Integer numRows = null;

  @JsonProperty("numColumns")
  private Integer numColumns = null;

  public SeatsLayout numRows(Integer numRows) {
    this.numRows = numRows;
    return this;
  }

  /**
   * The number of rows in the seats layout.
   * @return numRows
   **/
  @Schema(required = true, description = "The number of rows in the seats layout.")
      @NotNull

    public Integer getNumRows() {
    return numRows;
  }

  public void setNumRows(Integer numRows) {
    this.numRows = numRows;
  }

  public SeatsLayout numColumns(Integer numColumns) {
    this.numColumns = numColumns;
    return this;
  }

  /**
   * The number of columns in the seats layout.
   * @return numColumns
   **/
  @Schema(required = true, description = "The number of columns in the seats layout.")
      @NotNull

    public Integer getNumColumns() {
    return numColumns;
  }

  public void setNumColumns(Integer numColumns) {
    this.numColumns = numColumns;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SeatsLayout seatsLayout = (SeatsLayout) o;
    return Objects.equals(this.numRows, seatsLayout.numRows) &&
        Objects.equals(this.numColumns, seatsLayout.numColumns);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numRows, numColumns);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SeatsLayout {\n");
    
    sb.append("    numRows: ").append(toIndentedString(numRows)).append("\n");
    sb.append("    numColumns: ").append(toIndentedString(numColumns)).append("\n");
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
