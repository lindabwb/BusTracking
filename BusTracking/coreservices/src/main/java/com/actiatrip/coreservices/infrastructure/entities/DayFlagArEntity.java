package com.actiatrip.coreservices.infrastructure.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.*;

/** The persistent class for the day_flag_ar database table. */
@Table(name = "day_flag_ar")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class DayFlagArEntity extends AggregateRootEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "DAY_FLAG_AR_ID_GENERATOR", sequenceName = "DAY_FLAG_AR_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DAY_FLAG_AR_ID_GENERATOR")
    private long id;

    private String label;

    // bi-directional many-to-one association to DayOfYear
    @OneToMany(mappedBy = "dayFlagArEntity")
    private List<DayOfYearEntity> daysOfYear;

}
