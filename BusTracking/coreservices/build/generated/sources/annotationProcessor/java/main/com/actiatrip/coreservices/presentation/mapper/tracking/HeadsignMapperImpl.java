package com.actiatrip.coreservices.presentation.mapper.tracking;

import com.actiatrip.coreservices.application.domaine.aggregat.HeadsignAggregate;
import com.actiatrip.coreservices.presentation.dto.headsign.HeadsignRequestDto;
import com.actiatrip.coreservices.presentation.dto.headsign.HeadsignResponseDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-17T11:46:14+0200",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.2.jar, environment: Java 17.0.15 (Amazon.com Inc.)"
)
@Component
public class HeadsignMapperImpl implements HeadsignMapper {

    @Override
    public List<HeadsignResponseDto> toListResponseDto(List<HeadsignAggregate> headsignAggregates) {
        if ( headsignAggregates == null ) {
            return null;
        }

        List<HeadsignResponseDto> list = new ArrayList<HeadsignResponseDto>( headsignAggregates.size() );
        for ( HeadsignAggregate headsignAggregate : headsignAggregates ) {
            list.add( toResponseDto( headsignAggregate ) );
        }

        return list;
    }

    @Override
    public HeadsignResponseDto toResponseDto(HeadsignAggregate headsignAggregate) {
        if ( headsignAggregate == null ) {
            return null;
        }

        HeadsignResponseDto headsignResponseDto = new HeadsignResponseDto();

        return headsignResponseDto;
    }

    @Override
    public HeadsignAggregate toAggregate(HeadsignRequestDto headsignRequestDto) {
        if ( headsignRequestDto == null ) {
            return null;
        }

        HeadsignAggregate headsignAggregate = new HeadsignAggregate();

        return headsignAggregate;
    }
}
