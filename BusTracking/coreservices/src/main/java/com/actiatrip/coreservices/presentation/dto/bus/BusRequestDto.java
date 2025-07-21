package com.actiatrip.coreservices.presentation.dto.bus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
@Data
public class BusRequestDto {

    @JsonProperty("registration_plate")
    private String registrationPlate;

    private Boolean active;

    @JsonProperty("tracking_device_id")
    private String trackingDeviceId;
}

