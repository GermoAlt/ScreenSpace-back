package com.uade.screenspace.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * SeatReserved
 */
@Validated

public class SeatReserved   {
  @JsonProperty("seatRow")
  private BigDecimal seatRow = null;

  @JsonProperty("seatColumn")
  private BigDecimal seatColumn = null;

  public SeatReserved seatRow(BigDecimal seatRow) {
    this.seatRow = seatRow;
    return this;
  }

  /**
   * The number of row reserved
   * @return seatRow
   **/
  @Schema(required = true, description = "The number of row reserved")
      @NotNull

    @Valid
    public BigDecimal getSeatRow() {
    return seatRow;
  }

  public void setSeatRow(BigDecimal seatRow) {
    this.seatRow = seatRow;
  }

  public SeatReserved seatColumn(BigDecimal seatColumn) {
    this.seatColumn = seatColumn;
    return this;
  }

  /**
   * The number of column reserved
   * @return seatColumn
   **/
  @Schema(required = true, description = "The number of column reserved")
      @NotNull

    @Valid
    public BigDecimal getSeatColumn() {
    return seatColumn;
  }

  public void setSeatColumn(BigDecimal seatColumn) {
    this.seatColumn = seatColumn;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SeatReserved seatReserved = (SeatReserved) o;
    return Objects.equals(this.seatRow, seatReserved.seatRow) &&
        Objects.equals(this.seatColumn, seatReserved.seatColumn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(seatRow, seatColumn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SeatReserved {\n");
    
    sb.append("    seatRow: ").append(toIndentedString(seatRow)).append("\n");
    sb.append("    seatColumn: ").append(toIndentedString(seatColumn)).append("\n");
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
