package com.actiatrip.coreservices.infrastructure.entities;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

/** The persistent class for the line database table. */
@Getter
@Setter
@Table(name = "line")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class LineEntity extends AggregateRootEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "LINE_ID_GENERATOR", sequenceName = "LINE_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LINE_ID_GENERATOR")
    private Long id;

    @Column(name = "arabic_code")
    private String arabicCode;

    @Column(name = "arabic_description")
    private String arabicDescription;

    @Column(name = "latin_code")
    private String latinCode;

    @Column(name = "latin_description")
    private String latinDescription;

    private String color;

    // bi-directional many-to-one association to Alert
    @OneToMany(mappedBy = "lineEntity")
    private List<AlertEntity> alertEntities;

}

