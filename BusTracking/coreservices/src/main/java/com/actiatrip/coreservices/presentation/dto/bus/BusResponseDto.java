package com.actiatrip.coreservices.presentation.dto.bus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"id", "registration_number", "status", "tracking_device_id"})
public class BusResponseDto {

    @JsonProperty("id")
    private String uuid;

    @JsonProperty("registration_number")
    private String registrationPlate;

    private Boolean status;

    @JsonProperty("tracking_device_id")
    private String trackingDeviceId;
}

