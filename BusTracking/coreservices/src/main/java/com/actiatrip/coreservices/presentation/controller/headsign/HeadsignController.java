package com.actiatrip.coreservices.presentation.controller.headsign;

import com.actiatrip.coreservices.application.domaine.aggregat.HeadsignAggregate;
import com.actiatrip.coreservices.application.service.headsign.HeadsignService;
import com.actiatrip.coreservices.presentation.controller.ApiUrlUtils;
import com.actiatrip.coreservices.presentation.dto.headsign.HeadsignRequestDto;
import com.actiatrip.coreservices.presentation.dto.headsign.HeadsignResponseDto;
import com.actiatrip.coreservices.presentation.mapper.tracking.HeadsignMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiUrlUtils.HEADSIGN_API)
public class HeadsignController {

    @Autowired
    private HeadsignService headsignService;

    @Autowired
    private HeadsignMapper headsignMapper;

    @GetMapping("/all")
    public ResponseEntity<List<HeadsignResponseDto>> getHeadsigns() {
        List<HeadsignAggregate> headsignAggregates = headsignService.getAll();
        List<HeadsignResponseDto> response = headsignMapper.toListResponseDto(headsignAggregates);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/new")
    public ResponseEntity<HeadsignResponseDto> postHeadsign(@RequestBody HeadsignRequestDto headsign) {
        HeadsignAggregate headsignAggregate = headsignMapper.toAggregate(headsign);
        HeadsignResponseDto response = headsignMapper.toResponseDto(headsignService.add(headsignAggregate));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeadsignResponseDto> getHeadsign(@PathVariable String id) {
        HeadsignAggregate headsign = headsignService.getById(id);
        HeadsignResponseDto response = headsignMapper.toResponseDto(headsign);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

