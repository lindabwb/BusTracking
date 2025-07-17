package com.actiatrip.coreservices.application.domaine.aggregat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class HeadsignAggregate extends AggregateRoot {

    /** Aggregate serialNumber */
    private String serialNumber;

    /** Aggregate model */
    protected String model;

    /** Aggregate busAggregate */
    private BusAggregate busAggregate;
}
