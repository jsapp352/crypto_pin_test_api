package com.group13.crypto_pin_test;

import javax.persistence.*;

@Entity
public class Instructor
{
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String pin;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
