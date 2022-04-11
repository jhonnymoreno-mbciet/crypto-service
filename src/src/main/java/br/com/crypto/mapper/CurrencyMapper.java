package br.com.crypto.mapper;

import br.com.crypto.dtos.CurrencyDTO;
import br.com.crypto.models.CurrencyModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CurrencyMapper {
    CurrencyMapper INSTANCE = Mappers.getMapper(CurrencyMapper.class);

    List<CurrencyDTO> mapModelToDtoList(List<CurrencyModel>currencyModels);
    CurrencyDTO mapModelToDto(CurrencyModel currencyModel);
    CurrencyModel mapDtoToModel(CurrencyDTO currencyDTO);
}
