package com.actiatrip.coreservices.infrastructure.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.*;

/** The persistent class for the day_flag_fr database table. */
@Table(name = "day_flag_fr")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DayFlagFrEntity extends AggregateRootEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "DAY_FLAG_FR_ID_GENERATOR", sequenceName = "DAY_FLAG_FR_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DAY_FLAG_FR_ID_GENERATOR")
    private long id;

    private String label;

    // bi-directional many-to-one association to DayOfYear
    @OneToMany(mappedBy = "dayFlagFrEntity")
    private List<DayOfYearEntity> daysOfYear;
}
