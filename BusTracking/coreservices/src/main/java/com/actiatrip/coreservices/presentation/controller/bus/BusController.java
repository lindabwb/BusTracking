package com.actiatrip.coreservices.presentation.controller.bus;

import com.actiatrip.coreservices.application.domaine.aggregat.BusAggregate;
import com.actiatrip.coreservices.application.service.bus.BusService;
import com.actiatrip.coreservices.application.service.headsign.HeadsignService;
import com.actiatrip.coreservices.presentation.controller.ApiUrlUtils;

import java.util.List;

import com.actiatrip.coreservices.presentation.dto.bus.BusRequestDto;
import com.actiatrip.coreservices.presentation.dto.bus.BusResponseDto;
import com.actiatrip.coreservices.presentation.mapper.tracking.BusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiUrlUtils.BUS_API)
public class BusController {

    @Autowired
    private BusService busService;

    @Autowired
    private BusMapper busMapper;

    @GetMapping("/all")
    public ResponseEntity<List<BusResponseDto>> getHeadsigns() {
        List<BusAggregate> busAggregates = busService.getAll();
        List<BusResponseDto> response = busMapper.toListResponseDto(busAggregates);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/new")
    public ResponseEntity<BusResponseDto> postHeadsign(@RequestBody BusRequestDto bus) {
        BusAggregate busAggregate = busMapper.toAggregate(bus);
        BusResponseDto response = busMapper.toResponseDto(busService.add(busAggregate));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusResponseDto> getHeadsign(@PathVariable String id) {
        BusAggregate headsign = busService.getById(id);
        BusResponseDto response = busMapper.toResponseDto(headsign);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

