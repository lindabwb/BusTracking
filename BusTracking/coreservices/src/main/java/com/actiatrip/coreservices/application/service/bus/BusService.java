package com.actiatrip.coreservices.application.service.bus;

import com.actiatrip.coreservices.application.domaine.aggregat.BusAggregate;

import java.util.List;

public interface BusService {

    List<BusAggregate> getAll();

    BusAggregate add(BusAggregate bus);

    BusAggregate getById(String id);
}