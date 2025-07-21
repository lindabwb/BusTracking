package com.actiatrip.coreservices.infrastructure.persistence.repository.core;

import java.util.UUID;

import com.actiatrip.coreservices.infrastructure.entities.AggregateRootEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * Execute persistence methods coming from Spring Data JPA Repository. Ensure that the save, update
 * and delete operations works on well configured entities - save : the entity must have a generated
 * uuid + an etag value to 0 - update: Enable optimistic locking by ensuring the entity has an id
 * and an etag value coming from the database - Delete : Enable optimistic locking by ensuring the
 * entity has an id and an etag value coming from the database
 */
@Repository
public class JpaRepositoryExecutor {

    /** Save a root entity */
    public <T extends AggregateRootEntity, U extends JpaRepository<T, Long>> T saveAggregate(
            T aggregateRootEntity, U repository) {
        if (aggregateRootEntity == null) {
            throw new IllegalArgumentException("No  entity available for the save operation");
        }
        if (repository == null) {
            throw new IllegalArgumentException("No repository available for the save operation");
        }

        // entity uuid always managed by the application
        aggregateRootEntity.setUuid(UUID.randomUUID().toString());

        // new entities always have a "0" etag value
        aggregateRootEntity.setEtag(0);

        // create
        return repository.saveAndFlush(aggregateRootEntity);
    }

    public <T extends AggregateRootEntity, U extends JpaRepository<T, Long>> T updateAggregate(
            T aggregateEntity, U repository) {
        if (aggregateEntity == null) {
            throw new IllegalArgumentException("No aggregate entity available for the update operation");
        }
        if (!StringUtils.hasLength(aggregateEntity.getUuid())) {
            throw new IllegalArgumentException("No uuid available for the update operation");
        }
        if (repository == null) {
            throw new IllegalArgumentException("No repository available for the update operation");
        }

        // update
        return repository.saveAndFlush(aggregateEntity);
    }

    /**
     * Update an aggregate entity. Enable the optimistic lock strategy by retrieving the latest known
     * "etag" version in the database.
     *
     * @param aggregateEntity The aggregate entity to update
     * @param repository The aggregate repository
     * @param <T> The aggregate entity type
     * @param <U> The aggregate repository type
     */
    public <T extends AggregateRootEntity, U extends JpaRepository<T, Long>> void deleteAggregate(
            T aggregateEntity, U repository) {
        if (aggregateEntity == null) {
            throw new IllegalArgumentException("No aggregate entity available for the delete operation");
        }
        if (!StringUtils.hasLength(aggregateEntity.getUuid())) {
            throw new IllegalArgumentException("No uuid available for the update operation");
        }
        if (repository == null) {
            throw new IllegalArgumentException("No repository available for the delete operation");
        }
        // deletion
        repository.delete(aggregateEntity);
    }
}