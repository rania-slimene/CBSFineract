package com.example.cbsmiddleware.Account.AccountType.Controller;

import com.example.cbsmiddleware.Account.AccountType.DTO.CurrencyFineractDto;
import com.example.cbsmiddleware.Account.AccountType.Service.CurrencyFineractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cbs")
public class CurrencyController {
    @Autowired
    CurrencyFineractService CurrencyFineractService;
    @GetMapping("/currencies")
    public Object getAllcurrenciesFromFineract() {
        return CurrencyFineractService.saveCurrenciesFromApi();
    }

}
