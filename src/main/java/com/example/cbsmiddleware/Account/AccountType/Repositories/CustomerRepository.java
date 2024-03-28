package com.example.cbsmiddleware.Account.AccountType.Repositories;

import com.example.cbsmiddleware.Account.AccountType.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
