package com.actiatrip.coreservices.presentation.dto.bus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"registration_number", "status", "tracking_device_id"})
public class BusRequestDto {

    @JsonProperty("registration_number")
    private String registrationPlate;

    private Boolean status;

    @JsonProperty("tracking_device_id")
    private String trackingDeviceId;
}

