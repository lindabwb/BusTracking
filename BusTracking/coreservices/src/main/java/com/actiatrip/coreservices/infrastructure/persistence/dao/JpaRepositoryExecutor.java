package com.actiatrip.coreservices.infrastructure.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * TEMPORARY CLASS.
 */
@Component
public class JpaRepositoryExecutor {

    /**
     * Saves the given entity using the provided repository.
     *
     * @param entity the entity to save
     * @param repository the Spring Data JPA repository handling this entity
     * @param <T> the entity type
     * @param <ID> the ID type of the entity
     * @return the saved entity
     */
    public <T, ID> T saveAggregate(T entity, JpaRepository<T, ID> repository) {
        return repository.save(entity);
    }
}
