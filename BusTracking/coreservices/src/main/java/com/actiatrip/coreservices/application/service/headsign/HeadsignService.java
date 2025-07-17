package com.actiatrip.coreservices.application.service.headsign;

import com.actiatrip.coreservices.application.domaine.aggregat.HeadsignAggregate;
import java.util.List;

public interface HeadsignService {

    List<HeadsignAggregate> getAll();

    HeadsignAggregate add(HeadsignAggregate headsign);

    HeadsignAggregate getById(String id);
}

