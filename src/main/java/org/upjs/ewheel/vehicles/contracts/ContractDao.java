package org.upjs.ewheel.vehicles.contracts;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ContractDao {
    Contract create(Contract contract);

    Contract update(Contract contract);

    Contract findById(UUID id);

    Contract findByContractNumber(Long contractNumber);

    List<Contract> findByProvider(String provider);

    List<Contract> findByCategoryType(ContractType contractType);

    List<Contract> findByDate(LocalDate localDate);

    List<Contract> searchContract(String query);

    List<Contract> findAll();

    void deactivate(UUID id);

    Contract reactivate(UUID id);
}
