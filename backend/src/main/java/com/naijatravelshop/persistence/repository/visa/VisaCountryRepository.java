package com.naijatravelshop.persistence.repository.visa;

import com.naijatravelshop.persistence.model.enums.EntityStatus;
import com.naijatravelshop.persistence.model.visa.VisaCountry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface VisaCountryRepository extends CrudRepository<VisaCountry, Long> {

    List<VisaCountry> getAllByStatusEquals(EntityStatus entityStatus);

    Optional<VisaCountry> findFirstByCountryName(String countryName);

}
