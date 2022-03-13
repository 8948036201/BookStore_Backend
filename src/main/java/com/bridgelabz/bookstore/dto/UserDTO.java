package com.bridgelabz.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

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
