package com.actiatrip.coreservices.application.domaine.aggregat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

/**
 * Aggregate root representing a transit line,
 * with codes and descriptions in Arabic and Latin scripts,
 * a color, and associated alerts.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LineAggregate extends AggregateRoot {

    /** Arabic code for the line */
    private String arabicCode;

    /** Arabic description for the line */
    private String arabicDescription;

    /** Latin code for the line */
    private String latinCode;

    /** Latin description for the line */
    private String latinDescription;

    /** Line color */
    private String color;

    /** List of alerts related to this line */
    private List<AlertAggregate> alerts;
}