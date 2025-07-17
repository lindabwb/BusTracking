package com.actiatrip.coreservices.presentation.mapper.tracking;

import com.actiatrip.coreservices.application.domaine.aggregat.BusAggregate;
import com.actiatrip.coreservices.presentation.dto.bus.BusRequestDto;
import com.actiatrip.coreservices.presentation.dto.bus.BusResponseDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BusMapper {

    List<BusResponseDto> toListResponseDto(List<BusAggregate> busAggregates);

    BusResponseDto toResponseDto(BusAggregate busAggregate);

    BusAggregate toAggregate(BusRequestDto busRequestDto);
}

