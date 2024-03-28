package com.example.cbsmiddleware.Account.AccountType.Service;

import com.example.cbsmiddleware.Account.AccountType.DTO.CustomerFineractDto;
import com.example.cbsmiddleware.Account.AccountType.DTO.ProductSavingFineractDto;
import com.example.cbsmiddleware.Account.AccountType.Entities.Account;
import com.example.cbsmiddleware.Account.AccountType.Entities.Customer;
import com.example.cbsmiddleware.Account.AccountType.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerFineractService extends AbstractApiService {
    @Value("${fineract.api.url}")
    private String fineractApiUrl;
    @Autowired
    CustomerRepository CustomerRepository;
    public Object addCustomer(Customer CustomerCBS) {
        CustomerFineractDto fineractCustomer = mapToFineract(CustomerCBS);
        HttpHeaders headers = this.createHeaders();
        HttpEntity<CustomerFineractDto> entity = new HttpEntity<>(fineractCustomer, headers);

        ResponseEntity<Object> response = restTemplate.exchange(fineractApiUrl + "/clients",
                HttpMethod.POST, entity, Object.class);
       CustomerRepository.save(CustomerCBS);
        return response.getBody();
    }
    public Object getClient() {
        HttpHeaders headers = this.createHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Object> response = restTemplate.exchange(fineractApiUrl + "/clients", HttpMethod.GET, entity, Object.class);
        return response.getBody();
    }
    public Object updateCustomer(Customer CustomerCBS, Integer CustomerId) {
        CustomerFineractDto fineractCustomer = mapToFineract(CustomerCBS);;
        HttpHeaders headers = this.createHeaders();
        HttpEntity<CustomerFineractDto> entity = new HttpEntity<>(fineractCustomer, headers);

        ResponseEntity<Object> response = restTemplate.exchange(fineractApiUrl + "/clients/" + CustomerId ,
                HttpMethod.PUT, entity, Object.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            CustomerCBS.setId(CustomerId); // Assurez-vous que l'ID est correctement défini
            CustomerRepository.save(CustomerCBS);

        } else {
            throw new RuntimeException("Failed to update account type from Fineract");
        }
        return response.getBody();
    }
    public Object deleteCustomer(Integer CustomerId) {

        HttpHeaders headers = this.createHeaders();
        HttpEntity<Object> entity = new HttpEntity<>(headers);

        ResponseEntity<Object> response = restTemplate.exchange(fineractApiUrl + "/clients/" +CustomerId,
                HttpMethod.DELETE, entity, Object.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            CustomerRepository.deleteById(CustomerId);
        } else {
            throw new RuntimeException("Failed to update Customer from Fineract");
        }
        return response.getBody();
    }
    private CustomerFineractDto mapToFineract(Customer CustomerCBS) {
        CustomerFineractDto fineractCustomer= new CustomerFineractDto();

        fineractCustomer.setFirstname(CustomerCBS.getFirstName());
        fineractCustomer.setLastname(CustomerCBS.getLastName());
        fineractCustomer.setDateOfBirth(CustomerCBS.getBirthDate());
        fineractCustomer.setOfficeId(1);
        fineractCustomer.setLocale("en");
         fineractCustomer.setLegalFormId(1);
        fineractCustomer.setMobileNo(CustomerCBS.getMobile());
        fineractCustomer.setActive(true);
        fineractCustomer.setActivationDate("25 March 2024");
        fineractCustomer.setDateFormat("dd MMMM yyyy");
        fineractCustomer.setAccountNo("FD");
        CustomerCBS.setCity(CustomerCBS.getCity());
        CustomerCBS.setFullAddress(CustomerCBS.getFullAddress());;
        CustomerCBS.setLanguage(CustomerCBS.getLanguage());
        CustomerCBS.setProfileImage(CustomerCBS.getProfileImage());
        CustomerCBS.setCustomerStatus(CustomerCBS.getCustomerStatus());
        CustomerCBS.setIsVIP(CustomerCBS.getIsVIP());
        CustomerCBS.setJoinDate(CustomerCBS.getJoinDate());
        CustomerCBS.setPassword(CustomerCBS.getPassword());
        CustomerCBS.setFax(CustomerCBS.getFax());
        CustomerCBS.setNationality(CustomerCBS.getNationality());
        CustomerCBS.setNickName(CustomerCBS.getNickName());
        CustomerCBS.setCin(CustomerCBS.getCin());
        CustomerCBS.setPostCode(CustomerCBS.getPostCode());
        CustomerCBS.setCustomerNumber(CustomerCBS.getCustomerNumber());
        return fineractCustomer;
    }


}
