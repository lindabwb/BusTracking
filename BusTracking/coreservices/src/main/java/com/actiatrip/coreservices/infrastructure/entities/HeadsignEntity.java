package com.actiatrip.coreservices.infrastructure.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;

/** The persistent class for the line database table. */
@Table(name = "headsign")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HeadsignEntity extends AggregateRootEntity implements Serializable {

    private static final long serialVersionUID = 1874285261363829828L;

    @Id
    @SequenceGenerator(name = "HEADSIGN_ID_GENERATOR", sequenceName = "HEADSIGN_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HEADSIGN_ID_GENERATOR")
    private long id;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "model")
    private String model;

    @OneToOne(mappedBy = "headsignEntity")
    @JoinColumn(name = "headsign_id_ref", nullable = false)
    private BusEntity busEntity;
}