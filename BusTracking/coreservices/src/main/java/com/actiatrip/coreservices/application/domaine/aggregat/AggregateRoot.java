package com.actiatrip.coreservices.application.domaine.aggregat;

import com.actiatrip.coreservices.infrastructure.entities.AggregateRootEntity;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * General class representing the root of an aggregate. It contain fields that all aggregate should
 * have.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class AggregateRoot extends AggregateRootEntity {

    /** Aggregate functional identifier */
    private long id;

    /** Aggregate functional identifier */
    protected String uuid;

    /** Aggregate version */
    @Version protected int etag;
}
