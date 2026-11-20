package net.chrisrichardson.ftgo.common;

public class PersonName {
  private String firstName;
  private String lastName;

  private PersonName() {
  }

  public PersonName(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("familyName")
  public String getLastName() {
    return lastName;
  }
}