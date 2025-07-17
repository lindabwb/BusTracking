package com.actiatrip.coreservices.presentation.dto.headsign;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({ "serial_number", "model" })
public class HeadsignRequestDto {

    @JsonProperty("serial_number")
    private String serialNumber;

    private String model;
}
