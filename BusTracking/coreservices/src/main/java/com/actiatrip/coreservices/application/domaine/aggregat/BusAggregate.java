package com.actiatrip.coreservices.application.domaine.aggregat;

import lombok.*;
import uk.co.jemos.podam.common.PodamExclude;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class BusAggregate extends AggregateRoot {

    /** Aggregate registrationPlate */
    private String registrationPlate;

    /** Aggregate active */
    private Boolean active;

    /** Aggregate headsignAggregate */
    @PodamExclude
    private HeadsignAggregate headsignAggregate;

    /** Aggregate alertAggregates */
    @PodamExclude
    private List<AlertAggregate> alertAggregates;

    /** Aggregate locationAggregates */
    @PodamExclude
    private List<LocationAggregate> locationAggregates;

    /** Aggregate trips */
    @PodamExclude
    private List<TripAggregate> trips;

    /** Aggregate trackingDeviceId */
    private String trackingDeviceId;
}
