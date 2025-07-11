package com.actiatrip.coreservices.infrastructure.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/** The persistent class for the alert_flag_ar database table. */
@Table(name = "alert_flag")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AlertFlagEntity extends AggregateRootEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "ALERT_FLAG_ID_GENERATOR", sequenceName = "ALERT_FLAG_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALERT_FLAG_ID_GENERATOR")
    private long id;

    @Column(name = "label_fr")
    private String labelFr;

    @Column(name = "label_ar")
    private String labelAr;

    // bi-directional many-to-one association to Alert
    @OneToMany(mappedBy = "alertFlagEntity")
    private List<AlertEntity> alertEntities;

}

