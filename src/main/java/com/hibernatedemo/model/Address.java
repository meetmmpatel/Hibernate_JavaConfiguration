package com.hibernatedemo.model;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "CITY")
  private String city;

  @Column(name = "STATE")
  private String state;

  @Enumerated(EnumType.STRING)
  @Column(name = "ADDRESS_TYPE")
  private AddressType addressType;

  @Enumerated(EnumType.ORDINAL)
  @Column(name = "PHONE")
  private Phone phone;

  public Address() {}

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public AddressType getAddressType() {
    return addressType;
  }

  public void setAddressType(AddressType addressType) {
    this.addressType = addressType;
  }

  public Phone getPhone() {
    return phone;
  }

  public void setPhone(Phone phone) {
    this.phone = phone;
  }

  @Override
  public String toString() {
    return "Address{"
        + "id="
        + id
        + ", city='"
        + city
        + '\''
        + ", state='"
        + state
        + '\''
        + ", addressType="
        + addressType
        + ", phone="
        + phone
        + '}';
  }
}
