package com.actiatrip.coreservices.infrastructure.persistence.mapper;

import com.actiatrip.coreservices.application.domaine.aggregat.BusAggregate;
import com.actiatrip.coreservices.infrastructure.entities.BusEntity;
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
public class BusEntityMapperImpl implements BusEntityMapper {

    @Override
    public BusAggregate toAggregate(BusEntity busEntity) {
        if ( busEntity == null ) {
            return null;
        }

        BusAggregate busAggregate = new BusAggregate();

        busAggregate.setId( busEntity.getId() );
        busAggregate.setUuid( busEntity.getUuid() );
        busAggregate.setEtag( busEntity.getEtag() );
        busAggregate.setRegistrationPlate( busEntity.getRegistrationPlate() );
        busAggregate.setActive( busEntity.getActive() );
        busAggregate.setTrackingDeviceId( busEntity.getTrackingDeviceId() );

        return busAggregate;
    }

    @Override
    public BusEntity toEntity(BusAggregate busAggregate) {
        if ( busAggregate == null ) {
            return null;
        }

        BusEntity busEntity = new BusEntity();

        busEntity.setUuid( busAggregate.getUuid() );
        busEntity.setEtag( busAggregate.getEtag() );
        busEntity.setId( busAggregate.getId() );
        busEntity.setRegistrationPlate( busAggregate.getRegistrationPlate() );
        busEntity.setActive( busAggregate.getActive() );
        busEntity.setTrackingDeviceId( busAggregate.getTrackingDeviceId() );

        return busEntity;
    }

    @Override
    public List<BusAggregate> toListAggregates(List<BusEntity> busEntities) {
        if ( busEntities == null ) {
            return null;
        }

        List<BusAggregate> list = new ArrayList<BusAggregate>( busEntities.size() );
        for ( BusEntity busEntity : busEntities ) {
            list.add( toAggregate( busEntity ) );
        }

        return list;
    }
}
