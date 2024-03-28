package com.example.cbsmiddleware.Account.AccountType.DTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class CustomerFineractDto {
    private  String accountNo;
    private String dateOfBirth;
    private  String firstname;
    private String lastname;
    private String mobileNo;
    private Integer officeId;
    private Boolean active;
    private String activationDate;
    private String dateFormat;
    private String locale;
    private Integer legalFormId;






}
