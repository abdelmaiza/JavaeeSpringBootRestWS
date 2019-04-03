package com.wiredbrain.friends.model;

import javax.persistence.*;

@Embeddable
public class Zipcode {

    private String zip;
    private String plusFour;

    public Zipcode() {
    }

    public Zipcode(String zip, String plusFour) {
        this.zip = zip;
        this.plusFour = plusFour;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPlusFour() {
        return plusFour;
    }

    public void setPlusFour(String plusFour) {
        this.plusFour = plusFour;
    }
}
