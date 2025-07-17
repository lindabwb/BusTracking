package com.actiatrip.coreservices.application.service.headsign;

import com.actiatrip.coreservices.application.domaine.aggregat.HeadsignAggregate;
import java.util.List;
import java.util.Optional;

public interface HeadsignDao {

    List<HeadsignAggregate> getAll();

    Optional<HeadsignAggregate> getBySerialNumberAndModel(String serialNumber, String model);

    HeadsignAggregate save(HeadsignAggregate headsignAggregate);

    Optional<HeadsignAggregate> getByUuid(String uuid);
}

