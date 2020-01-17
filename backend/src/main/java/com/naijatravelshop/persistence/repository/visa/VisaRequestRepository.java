package com.naijatravelshop.persistence.repository.visa;

import com.naijatravelshop.persistence.model.visa.VisaRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.Timestamp;
import java.util.List;

public interface VisaRequestRepository extends PagingAndSortingRepository<VisaRequest, Long> {
    List<VisaRequest> getAllByStatusEqualsAndDateCreatedBetween(Boolean processed, Timestamp start, Timestamp stop);

    List<VisaRequest> getAllByProcessed(Boolean processed);

    List<VisaRequest> getAllByDateCreatedBetween(Timestamp start, Timestamp stop);
}