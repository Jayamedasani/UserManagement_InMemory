package org.example.model;

import java.util.Objects;

public class UserDetails {
    private int id;
    private String name;
    private String address;
    public UserDetails() {
    }
    public UserDetails(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetails otherUserDetails = (UserDetails) o;
        return id == otherUserDetails.id && Objects.equals(name, otherUserDetails.name) && Objects.equals(address, otherUserDetails.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }
}
