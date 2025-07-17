package com.actiatrip.coreservices.application.domaine.aggregat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class DayOfYearAggregate extends AggregateRoot {

    /** The date representing this day of the year */
    private Date day;

    /** Reference to the Arabic day flag aggregate */
    private DayFlagArAggregate dayFlagAr;

    /** Reference to the French day flag aggregate */
    private DayFlagFrAggregate dayFlagFr;
}
