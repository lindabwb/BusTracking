package com.actiatrip.coreservices.application.domaine.aggregat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AlertFlagAggregate extends AggregateRoot {

    /** Aggregate french label */
    private String labelFr;

    /** Aggregate arabic label */
    private String labelAr;
}

