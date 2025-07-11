package com.actiatrip.coreservices.infrastructure.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.*;

/** The persistent class for the alert database table. */
@Table(name = "alert")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AlertEntity extends AggregateRootEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "ALERT_ID_GENERATOR", sequenceName = "ALERT_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALERT_ID_GENERATOR")
    private long id;

    @Column(name = "alert_time")
    private LocalDateTime alertTime;

    private Boolean seen;

    @Column(name = "trip_back")
    private Boolean tripBack;

    // bi-directional many-to-one association to AlertFlagAr
    @ManyToOne
    @JoinColumn(name = "alert_flag_id_ref")
    private AlertFlagEntity alertFlagEntity;

    @ManyToOne
    @JoinColumn(name = "line_id_ref")
    private LineEntity lineEntity;

    // bi-directional many-to-one association to Bus
    @ManyToOne
    @JoinColumn(name = "bus_id_ref")
    private BusEntity busEntity;
}
