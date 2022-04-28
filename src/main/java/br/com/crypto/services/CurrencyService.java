package br.com.crypto.services;

import br.com.crypto.models.CurrencyModel;
import br.com.crypto.repositories.CurrencyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CurrencyService {

    final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository){
        this.currencyRepository = currencyRepository;
    }

    @Transactional
    public CurrencyModel save(CurrencyModel currencyModel) {
        return currencyRepository.save(currencyModel);
    }

    public Optional<CurrencyModel> findById(UUID id) {
        return currencyRepository.findById(id);
    }

    @Transactional
    public void delete(UUID id) {currencyRepository.deleteById(id);
    }

    public List<CurrencyModel> existsByNameOrCode(Optional<String> name, Optional<String> code){
        if(name.isPresent() || code.isPresent()){
            return currencyRepository.existsByNameOrCode(name, code);
        }
            return currencyRepository.findAll();
    }

}
