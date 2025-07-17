package com.actiatrip.coreservices.presentation.dto.headsign;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({ "id", "serial_number", "model" })
public class HeadsignResponseDto {

    @JsonProperty("id")
    private String uuid;

    @JsonProperty("serial_number")
    private String serialNumber;

    private String model;
}
