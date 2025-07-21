package com.actiatrip.coreservices.infrastructure.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.*;

/** The persistent class for the day_of_year database table. */
@Table(name = "day_of_year")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class DayOfYearEntity extends AggregateRootEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "DAY_OF_YEAR_ID_GENERATOR", sequenceName = "DAY_OF_YEAR_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DAY_OF_YEAR_ID_GENERATOR")
    private long id;

    @Temporal(TemporalType.DATE)
    private Date day;

    // bi-directional many-to-one association to DayFlagAr
    @ManyToOne
    @JoinColumn(name = "day_flag_ar_id_ref")
    private DayFlagArEntity dayFlagArEntity;

    // bi-directional many-to-one association to DayFlagFr
    @ManyToOne
    @JoinColumn(name = "day_flag_fr_id_ref")
    private DayFlagFrEntity dayFlagFrEntity;
}
