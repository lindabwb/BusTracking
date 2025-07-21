package com.actiatrip.coreservices.infrastructure.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.*;

/** The persistent class for the stop database table. */
@Table(name = "stop")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StopEntity extends AggregateRootEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "STOP_ID_GENERATOR", sequenceName = "STOP_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STOP_ID_GENERATOR")
    private long id;

    @Column(name = "stop_code")
    private String stopCode;

    @Column(name = "arabic_name")
    private String arabicName;

    @Column(name = "latin_name")
    private String latinName;

    private Double latitude;

    private Double longitude;

    @Column(name = "trip_back")
    private Boolean tripBack;


}

