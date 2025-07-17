package com.actiatrip.coreservices.infrastructure.persistence.repository;

import java.util.Optional;
import com.actiatrip.coreservices.infrastructure.entities.HeadsignEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeadsignRepository extends JpaRepository<HeadsignEntity, Long> {

    Optional<HeadsignEntity> findBySerialNumberAndModel(String serialNumber, String model);

    Optional<HeadsignEntity> findByUuid(String uuid);
}

