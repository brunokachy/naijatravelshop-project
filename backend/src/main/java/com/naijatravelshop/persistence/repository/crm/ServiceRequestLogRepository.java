package com.naijatravelshop.persistence.repository.crm;

import com.naijatravelshop.persistence.model.crm.ServiceRequestLog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ServiceRequestLogRepository extends PagingAndSortingRepository<ServiceRequestLog, Long> {
}
