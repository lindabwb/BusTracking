package com.actiatrip.coreservices.application.domaine.aggregat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DayFlagFrAggregate extends AggregateRoot {

    /** French day flag aggregate */
    private String label;
}
