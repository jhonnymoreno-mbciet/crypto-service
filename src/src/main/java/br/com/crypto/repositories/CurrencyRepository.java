package br.com.crypto.repositories;

import br.com.crypto.models.CurrencyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyModel, UUID> {
    boolean existsByNameAndCode(String name, String code);
    CurrencyModel findByNameOrCode(Optional<String> name, Optional<String> code);
    List<CurrencyModel> existsByNameOrCode(Optional<String> name, Optional<String> code);

}
