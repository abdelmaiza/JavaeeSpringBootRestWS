package com.wiredbrain.friends.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("first_name")
    @NotBlank
    private String firstName;
    @JsonProperty("last_name")
    @NotBlank
    private String lastName;
    int age;
    @JsonIgnore
    private boolean married;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;

    public Friend() {
    }

    public Friend(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Friend(@NotBlank String firstName, @NotBlank String lastName, int age, boolean married, List<Address> addresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.married = married;
        this.addresses = addresses;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

}
