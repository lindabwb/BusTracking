package com.actiatrip.coreservices.application.service.bus;

import com.actiatrip.coreservices.application.domaine.aggregat.BusAggregate;
import com.actiatrip.coreservices.infrastructure.entities.BusEntity;

import java.util.List;
import java.util.Optional;

public interface BusDao {

    List<BusAggregate> getAll();

    Optional<BusAggregate> getByTrackingDeviceId(String trackingDeviceId);

    Optional<BusAggregate> getByRegistrationPlate(String registrationPlate);

    List<BusEntity> findByActive(Boolean active);

    BusAggregate save(BusAggregate busAggregate);

    Optional<BusAggregate> getByUuid(String uuid);
}
