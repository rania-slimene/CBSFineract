package com.example.cbsmiddleware.Account.AccountType.Repositories;

import com.example.cbsmiddleware.Account.AccountType.Entities.Currencies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currencies,Integer> {
}
