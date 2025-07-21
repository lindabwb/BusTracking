package com.actiatrip.coreservices.infrastructure.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.*;

/** The persistent class for the bus database table. */
@Table(name = "bus")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BusEntity extends AggregateRootEntity implements Serializable {

    private static final long serialVersionUID = 2946909767886762505L;

    @Id
    @SequenceGenerator(name = "BUS_ID_GENERATOR", sequenceName = "BUS_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUS_ID_GENERATOR")
    private long id;

    private String registrationPlate;

    private Boolean active;

    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false)
    @JoinColumn(name = "headsign_id_ref")
    private HeadsignEntity headsignEntity;

    // bi-directional many-to-one association to Alert
    @OneToMany(mappedBy = "busEntity")
    private List<AlertEntity> alertEntities;

    @Column(name = "tracking_device_id_ref")
    private String trackingDeviceId;
}