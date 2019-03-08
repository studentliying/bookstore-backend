package com.example.springboot.entity;

import java.io.Serializable;
import java.util.List;

public class Address implements Serializable {
    private List<String> addresses;

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }
}
