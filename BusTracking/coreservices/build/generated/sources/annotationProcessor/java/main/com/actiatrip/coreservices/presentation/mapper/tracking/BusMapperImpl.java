package com.actiatrip.coreservices.presentation.mapper.tracking;

import com.actiatrip.coreservices.application.domaine.aggregat.BusAggregate;
import com.actiatrip.coreservices.presentation.dto.bus.BusRequestDto;
import com.actiatrip.coreservices.presentation.dto.bus.BusResponseDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-17T13:55:37+0200",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.2.jar, environment: Java 17.0.15 (Amazon.com Inc.)"
)
@Component
public class BusMapperImpl implements BusMapper {

    @Override
    public List<BusResponseDto> toListResponseDto(List<BusAggregate> busAggregates) {
        if ( busAggregates == null ) {
            return null;
        }

        List<BusResponseDto> list = new ArrayList<BusResponseDto>( busAggregates.size() );
        for ( BusAggregate busAggregate : busAggregates ) {
            list.add( toResponseDto( busAggregate ) );
        }

        return list;
    }

    @Override
    public BusResponseDto toResponseDto(BusAggregate busAggregate) {
        if ( busAggregate == null ) {
            return null;
        }

        BusResponseDto busResponseDto = new BusResponseDto();

        return busResponseDto;
    }

    @Override
    public BusAggregate toAggregate(BusRequestDto busRequestDto) {
        if ( busRequestDto == null ) {
            return null;
        }

        BusAggregate busAggregate = new BusAggregate();

        return busAggregate;
    }
}
