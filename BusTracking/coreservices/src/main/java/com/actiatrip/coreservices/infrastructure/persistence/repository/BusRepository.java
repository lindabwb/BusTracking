package com.actiatrip.coreservices.infrastructure.persistence.repository;

import com.actiatrip.coreservices.infrastructure.entities.BusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface BusRepository extends JpaRepository<BusEntity, Long> {

    /** Find a bus by UUID */
    Optional<BusEntity> findByUuid(String uuid);

    /** Find a bus by registration plate only */
    Optional<BusEntity> findByRegistrationPlate(String registrationPlate);

    /** List buses by their status */
    List<BusEntity> findByActive(Boolean active);

    Optional<BusEntity> findByTrackingDeviceId(String trackingDeviceId);
}
