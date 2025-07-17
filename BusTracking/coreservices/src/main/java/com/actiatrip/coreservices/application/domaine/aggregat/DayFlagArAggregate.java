package com.actiatrip.coreservices.application.domaine.aggregat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DayFlagArAggregate extends AggregateRoot {

    /** Arabic day flag aggregate */
    private String label;
}
