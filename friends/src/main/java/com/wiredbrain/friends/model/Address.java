package com.wiredbrain.friends.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;
    private String state;

    //@Embedded
    //private Zipcode zipcode;


    public Address() {
    }

    public Address(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
        //this.zipcode = zipcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //public Zipcode getZipcode() {
    //    return zipcode;
    //}

    //public void setZipcode(Zipcode zipcode) {
    //this.zipcode = zipcode;
    //}
}
