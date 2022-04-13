package br.com.crypto.controllers;

import br.com.crypto.dtos.CurrencyDTO;
import br.com.crypto.mapper.CurrencyMapper;
import br.com.crypto.models.CurrencyModel;
import br.com.crypto.services.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/crypto-ativo")
public class CurrencyController {
    final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }


    @PostMapping
    public ResponseEntity<Object> saveCurrency(@RequestBody @Valid CurrencyDTO currencyDto){
        if(currencyService.existsByNameAndCode(currencyDto.getName(), currencyDto.getCode())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Crypto Asset already exists!");
        }
        currencyDto.setCreatedat(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(currencyService.save(CurrencyMapper.INSTANCE.mapDtoToModel(currencyDto)));
    }

    @GetMapping
    public List<CurrencyDTO>getCurrency(@RequestParam @Nullable Optional<String> name,@RequestParam @Nullable Optional<String> code){
        List<CurrencyDTO> currencyDto = CurrencyMapper.INSTANCE.mapModelToDtoList(currencyService.existsByNameOrCode(name, code));
        return currencyDto;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCurrency(@PathVariable(value = "id")UUID id){
        Optional<CurrencyModel> currencyOptional = currencyService.findById(id);
        if(!currencyOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Crypto Asset not found");
        }
        currencyService.delete(currencyOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Crypto Asset deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> putCurrency(@PathVariable(value = "id")UUID id,
                                                @RequestBody CurrencyDTO currencyDTO){
        Optional<CurrencyModel> currencyModelOptional = currencyService.findById(id);
        if(!currencyModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Crypto Asset not found");
        }

        if(currencyDTO.getName() == null){
            currencyDTO.setName(currencyModelOptional.get().getName());
        }
        if(currencyDTO.getCode() == null){
            currencyDTO.setCode(currencyModelOptional.get().getCode());
        }
        currencyDTO.setId(id);
        currencyDTO.setCreatedat(currencyModelOptional.get().getCreatedat());

        CurrencyModel currencyModel = CurrencyMapper.INSTANCE.mapDtoToModel(currencyDTO);
        return ResponseEntity.status(HttpStatus.OK).body(currencyService.save(currencyModel));
    }
}
