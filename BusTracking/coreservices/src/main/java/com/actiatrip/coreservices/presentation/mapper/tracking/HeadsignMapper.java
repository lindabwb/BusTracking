package com.actiatrip.coreservices.presentation.mapper.tracking;

import com.actiatrip.coreservices.application.domaine.aggregat.HeadsignAggregate;
import com.actiatrip.coreservices.presentation.dto.headsign.HeadsignRequestDto;
import com.actiatrip.coreservices.presentation.dto.headsign.HeadsignResponseDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HeadsignMapper {

    List<HeadsignResponseDto> toListResponseDto(List<HeadsignAggregate> headsignAggregates);

    HeadsignResponseDto toResponseDto(HeadsignAggregate headsignAggregate);

    HeadsignAggregate toAggregate(HeadsignRequestDto headsignRequestDto);
}

