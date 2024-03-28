package com.example.cbsmiddleware.Account.AccountType.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private String CustomerNumber;
    private String firstName;
    private String lastName;
    private String nickName;
    private Integer cin;
    private String gender;
    private String birthDate;
    private String nationality;
    private String postCode;
    private String mobile;
    private String email;
    private String fax;
    private String city;
    private String fullAddress;
    private String language;
    private byte profileImage;
    private Boolean CustomerStatus;
    private Boolean isVIP;
    private LocalDateTime joinDate;
    private String password;






}
