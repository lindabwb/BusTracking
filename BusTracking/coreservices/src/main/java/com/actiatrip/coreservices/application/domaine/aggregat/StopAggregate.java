package com.actiatrip.coreservices.application.domaine.aggregat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class StopAggregate extends AggregateRoot {

    /** Code identifying the stop */
    private String stopCode;

    /** Arabic name of the stop */
    private String arabicName;

    /** Latin name of the stop */
    private String latinName;

    /** Latitude coordinate of the stop */
    private Double latitude;

    /** Longitude coordinate of the stop */
    private Double longitude;

    /** Indicates if this stop is part of a return trip */
    private Boolean tripBack;
}
