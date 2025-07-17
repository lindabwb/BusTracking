package com.actiatrip.coreservices.infrastructure.persistence.mapper;

import com.actiatrip.coreservices.application.domaine.aggregat.BusAggregate;
import com.actiatrip.coreservices.infrastructure.entities.BusEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BusEntityMapper {

    BusAggregate toAggregate(BusEntity busEntity);

    BusEntity toEntity(BusAggregate busAggregate);

    List<BusAggregate> toListAggregates(List<BusEntity> busEntities);
}
