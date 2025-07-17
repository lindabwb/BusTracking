package com.actiatrip.coreservices.infrastructure.persistence.mapper;

import com.actiatrip.coreservices.application.domaine.aggregat.HeadsignAggregate;
import com.actiatrip.coreservices.infrastructure.entities.HeadsignEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Named("TrackingDeviceEntityMapper")
public interface HeadsignEntityMapper {

    List<HeadsignAggregate> toListAggregates(List<HeadsignEntity> trackingDeviceEntity);

    HeadsignAggregate toAggregate(HeadsignEntity trackingDeviceEntity);

    HeadsignEntity toEntity(HeadsignAggregate trackingDeviceAggregate);
}
