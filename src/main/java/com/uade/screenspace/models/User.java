package com.uade.screenspace.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * User
 */
@Validated

public class User   {
  @JsonProperty("email")
  private String email = null;

  @JsonProperty("isOwner")
  private Boolean isOwner = null;

  @JsonProperty("profilePictureURL")
  private String profilePictureURL = null;

  @JsonProperty("name")
  private String name = null;

  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The email address of the user.
   * @return email
   **/
  @Schema(required = true, description = "The email address of the user.")
      @NotNull

    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User isOwner(Boolean isOwner) {
    this.isOwner = isOwner;
    return this;
  }

  /**
   * Indicates if user is owner
   * @return isOwner
   **/
  @Schema(required = true, description = "Indicates if user is owner")
      @NotNull

    public Boolean isIsOwner() {
    return isOwner;
  }

  public void setIsOwner(Boolean isOwner) {
    this.isOwner = isOwner;
  }

  public User profilePictureURL(String profilePictureURL) {
    this.profilePictureURL = profilePictureURL;
    return this;
  }

  /**
   * URL to fetch profile picture
   * @return profilePictureURL
   **/
  @Schema(description = "URL to fetch profile picture")
  
    public String getProfilePictureURL() {
    return profilePictureURL;
  }

  public void setProfilePictureURL(String profilePictureURL) {
    this.profilePictureURL = profilePictureURL;
  }

  public User name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the user
   * @return name
   **/
  @Schema(description = "Name of the user")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.email, user.email) &&
        Objects.equals(this.isOwner, user.isOwner) &&
        Objects.equals(this.profilePictureURL, user.profilePictureURL) &&
        Objects.equals(this.name, user.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, isOwner, profilePictureURL, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    isOwner: ").append(toIndentedString(isOwner)).append("\n");
    sb.append("    profilePictureURL: ").append(toIndentedString(profilePictureURL)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
