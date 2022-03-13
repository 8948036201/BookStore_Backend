package com.bridgelabz.bookstore.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private String kyc;
    private LocalDate dob;
    private LocalDate registeredDate;
    private LocalDate updatedDate;
    private LocalDate purchaseDate;
    private LocalDate expiryDate;
    private String email;
    private String password;
    private Boolean verify;
    private String otp;

}
