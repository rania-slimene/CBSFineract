package com.example.cbsmiddleware.Account.AccountType.DTO;
import lombok.Data;
@Data
public class CurrencyFineractDto {
    private String code;
    private  Integer decimalPlaces;
    private String displayLabel;
    private String displaySymbol;
    private String inMultiplesOf;
    private  String name;
    private String nameCode;
}
