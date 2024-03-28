package com.example.cbsmiddleware.Account.AccountType.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Currencies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id ;
    private String isoCode;
    private String isoNum;
    private  String currencyName;
    private Boolean enabled;
    private Integer unit;
    private  String transferRate;
    private LocalDateTime lastUpdated;
    private String currencyOrder;
}
