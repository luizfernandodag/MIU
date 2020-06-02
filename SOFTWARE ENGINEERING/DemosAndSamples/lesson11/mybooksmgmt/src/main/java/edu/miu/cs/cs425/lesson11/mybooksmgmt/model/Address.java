package edu.miu.cs.cs425.lesson11.mybooksmgmt.model;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private String houseNumber;
    private String street;
    private String city;
    private Integer zipCode;
    private String state;

    public Address(Integer addressId, String houseNumber, String street, String city, Integer zipCode, String state) {
        this.addressId = addressId;
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
    }

    public Address(String houseNumber, String street, String city, Integer zipCode, String state) {
        this(null, houseNumber, street, city, zipCode, state);
    }

    public Address() {
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /*
    1004 S Burlington Avenue
    Fairfield, IA 52556
     */
    @Override
    public String toString() {
        return new StringJoiner("")
                .add(houseNumber + " " + street + "\n")
                .add(city + ", " + state + " " + zipCode)
                .toString();
    }
}
