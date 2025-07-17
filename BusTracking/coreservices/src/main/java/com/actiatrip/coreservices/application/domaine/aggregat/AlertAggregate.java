package com.actiatrip.coreservices.application.domaine.aggregat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
public class AlertAggregate extends AggregateRoot {

    /** Aggregate time of the alert */
    private LocalDateTime alertTime;

    /** Aggregate seen */
    private Boolean seen;

    /** Aggregate trip */
    private Boolean tripBack;

    /** Aggregate */
    private AlertFlagAggregate alertFlagAggregate;

    /** Aggregate line */
    private LineAggregate lineAggregate;

    /** Aggregate bus */
    private BusAggregate busAggregate;
}
