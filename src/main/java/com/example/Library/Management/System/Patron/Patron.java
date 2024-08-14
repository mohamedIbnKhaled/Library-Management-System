package com.example.Library.Management.System.Patron;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patron_id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private LocalDate membership_date ;

    public Patron() {
    }

    public Patron(int patron_id, String name, String email, String address, String phone, LocalDate membership_date) {
        this.patron_id = patron_id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.membership_date = membership_date;
    }

    public Patron(String name, String email, String phone, String address, LocalDate membership_date) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.membership_date = membership_date;
    }

    public int getPatron_id() {
        return patron_id;
    }

    public void setPatron_id(int patron_id) {
        this.patron_id = patron_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getMembership_date() {
        return membership_date;
    }

    public void setMembership_date(LocalDate membership_date) {
        this.membership_date = membership_date;
    }

}

