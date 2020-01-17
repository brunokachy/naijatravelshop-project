package com.naijatravelshop.persistence.repository.portal;

import com.naijatravelshop.persistence.model.portal.Setting;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SettingRepository extends CrudRepository<Setting, Long> {

    Optional<Setting> findFirstByNameEquals(String name);
}
