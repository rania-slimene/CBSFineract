package com.example.cbsmiddleware.Account.AccountType.Service;


import com.example.cbsmiddleware.Account.AccountType.DTO.CurrencyFineractDto;
import com.example.cbsmiddleware.Account.AccountType.Entities.Currencies;
import com.example.cbsmiddleware.Account.AccountType.Repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyFineractService extends AbstractApiService {
    @Value("${fineract.api.url}")
    private String fineractApiUrl;
    @Autowired
    CurrencyRepository CurrencyRepository;
    /*public Object getcurrencies() {
        HttpHeaders headers = this.createHeaders();
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<Object> response = restTemplate.exchange(fineractApiUrl + "/currencies", HttpMethod.GET, entity, Object.class);
        return response.getBody();
    }
    */

        public Object saveCurrenciesFromApi() {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<Object> entity = new HttpEntity<>(headers);

            ResponseEntity<CurrencyFineractDto[]> response = restTemplate.exchange(
                    fineractApiUrl + "/currencies",
                    HttpMethod.GET,
                    entity,
                    CurrencyFineractDto[].class);

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                List<CurrencyFineractDto> currencyDtos = Arrays.asList(response.getBody());
                List<Currencies> currencies = currencyDtos.stream()
                        .map(this::mapToEntity)
                        .collect(Collectors.toList());
                CurrencyRepository.saveAll(currencies);
            }
            return null;
        }

        private Currencies mapToEntity(CurrencyFineractDto dto) {
            Currencies currency = new Currencies();
            // Supposer que Currencies a des setters pour chacun des champs
            currency.setCurrencyName(dto.getName());
            currency.setIsoCode(dto.getCode());
            // Autres mappages nécessaires ici
            return currency;
        }
   /* private CurrencyFineractDto mapToFineract(Currencies currencyCBS) {
        CurrencyFineractDto fineractCurrency= new CurrencyFineractDto();

        fineractCurrency.setCode(currencyCBS.getIsoCode());
        fineractCurrency.setName(currencyCBS.getCurrencyName());
        fineractCurrency.setDisplaySymbol(currencyCBS.getIsoNum());
        fineractCurrency.setNameCode("name");
        fineractCurrency.setDecimalPlaces(Integer.valueOf((currencyCBS.getCurrencyOrder())));
        fineractCurrency.setInMultiplesOf("4");


        return fineractCurrency;
    }*/

}
