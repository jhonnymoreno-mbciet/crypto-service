package br.com.crypto.services;

import br.com.crypto.repositories.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CurrencyExitsValidator {

    final CurrencyRepository currencyRepository;

    public CurrencyExitsValidator(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public void validatorNameAndCode(String name, String code) throws Exception {
        if (currencyRepository.existsByNameAndCode(name, code)) {
            throw new Exception("Currency Already Exists!");
        }
    }

    public void validatorId(UUID id) throws Exception {
        if(currencyRepository.existsById(id)){
            throw new Exception("Currency not found!");
        }
    }
}
