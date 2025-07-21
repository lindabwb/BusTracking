package com.actiatrip.coreservices.infrastructure.persistence.mapper;

import com.actiatrip.coreservices.application.domaine.aggregat.HeadsignAggregate;
import com.actiatrip.coreservices.infrastructure.entities.HeadsignEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-21T15:30:59+0200",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.2.jar, environment: Java 17.0.15 (Amazon.com Inc.)"
)
@Component
public class HeadsignEntityMapperImpl implements HeadsignEntityMapper {

    @Override
    public List<HeadsignAggregate> toListAggregates(List<HeadsignEntity> trackingDeviceEntity) {
        if ( trackingDeviceEntity == null ) {
            return null;
        }

        List<HeadsignAggregate> list = new ArrayList<HeadsignAggregate>( trackingDeviceEntity.size() );
        for ( HeadsignEntity headsignEntity : trackingDeviceEntity ) {
            list.add( toAggregate( headsignEntity ) );
        }

        return list;
    }

    @Override
    public HeadsignAggregate toAggregate(HeadsignEntity trackingDeviceEntity) {
        if ( trackingDeviceEntity == null ) {
            return null;
        }

        HeadsignAggregate headsignAggregate = new HeadsignAggregate();

        headsignAggregate.setId( trackingDeviceEntity.getId() );
        headsignAggregate.setUuid( trackingDeviceEntity.getUuid() );
        headsignAggregate.setEtag( trackingDeviceEntity.getEtag() );
        headsignAggregate.setSerialNumber( trackingDeviceEntity.getSerialNumber() );
        headsignAggregate.setModel( trackingDeviceEntity.getModel() );

        return headsignAggregate;
    }

    @Override
    public HeadsignEntity toEntity(HeadsignAggregate trackingDeviceAggregate) {
        if ( trackingDeviceAggregate == null ) {
            return null;
        }

        HeadsignEntity headsignEntity = new HeadsignEntity();

        headsignEntity.setUuid( trackingDeviceAggregate.getUuid() );
        headsignEntity.setEtag( trackingDeviceAggregate.getEtag() );
        headsignEntity.setId( trackingDeviceAggregate.getId() );
        headsignEntity.setSerialNumber( trackingDeviceAggregate.getSerialNumber() );
        headsignEntity.setModel( trackingDeviceAggregate.getModel() );

        return headsignEntity;
    }
}
