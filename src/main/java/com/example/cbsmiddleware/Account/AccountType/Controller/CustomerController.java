package com.example.cbsmiddleware.Account.AccountType.Controller;

import com.example.cbsmiddleware.Account.AccountType.Entities.Account;
import com.example.cbsmiddleware.Account.AccountType.Entities.Customer;
import com.example.cbsmiddleware.Account.AccountType.Service.CustomerFineractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cbs")
public class CustomerController {
    @Autowired
    CustomerFineractService CustomerFineractService;
    @PostMapping("Customer")
    public ResponseEntity<Object> addCustomer(@RequestBody Customer CBScustomer) {
        Object response = CustomerFineractService.addCustomer(CBScustomer);
        return ResponseEntity.ok(response);
    }
    @PutMapping("Clients/{id}")
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer CustomerCBS , @PathVariable Integer id ) {
        Object response = CustomerFineractService.updateCustomer(CustomerCBS, id);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("Clients/{id}")
    public Object deleteCustomer(@PathVariable Integer id ){
        return CustomerFineractService.deleteCustomer(id);
    }
    @GetMapping("clients")
    public Object getAllClientsFromFineract() {
        return CustomerFineractService.getClient();
    }
}

