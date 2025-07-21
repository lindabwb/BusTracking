package com.actiatrip.coreservices.presentation.dto.bus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"id", "registration_plate", "active", "tracking_device_id"})
public class BusResponseDto {

    @JsonProperty("id")
    private String uuid;

    @JsonProperty("registration_plate")
    private String registrationPlate;

    private Boolean active;

    @JsonProperty("tracking_device_id")
    private String trackingDeviceId;
}

