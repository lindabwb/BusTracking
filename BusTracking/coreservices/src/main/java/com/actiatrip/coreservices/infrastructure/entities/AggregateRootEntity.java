package com.actiatrip.coreservices.infrastructure.entities;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Data;

/**
 * General class representing the root of an aggregate. It contain fields that all aggregate should
 * have.
 */
@Data
@MappedSuperclass
public abstract class AggregateRootEntity {

  /** Aggregate functional identifier */
  protected String uuid;

  /** Aggregate version */
  @Version protected int etag;
}
