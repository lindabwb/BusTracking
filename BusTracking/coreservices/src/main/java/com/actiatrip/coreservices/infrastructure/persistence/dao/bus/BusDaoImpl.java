package com.actiatrip.coreservices.infrastructure.persistence.dao.bus;

import com.actiatrip.coreservices.application.domaine.aggregat.BusAggregate;
import com.actiatrip.coreservices.application.service.bus.BusDao;
import com.actiatrip.coreservices.infrastructure.entities.BusEntity;
import com.actiatrip.coreservices.infrastructure.persistence.dao.JpaRepositoryExecutor;
import com.actiatrip.coreservices.infrastructure.persistence.mapper.BusEntityMapper;
import com.actiatrip.coreservices.infrastructure.persistence.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class BusDaoImpl implements BusDao {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private BusEntityMapper busEntityMapper;

    @Autowired
    private JpaRepositoryExecutor repositoryExecutor;

    @Override
    public List<BusAggregate> getAll() {
        List<BusEntity> busEntities = busRepository.findAll();
        if (busEntities.isEmpty()) {
            return Collections.emptyList();
        }
        return busEntityMapper.toListAggregates(busEntities);
    }

    @Override
    public Optional<BusAggregate> getByTrackingDeviceId(String trackingDeviceId) {
        Optional<BusEntity> busEntity = busRepository.findByTrackingDeviceId(trackingDeviceId);
        if (busEntity.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(busEntityMapper.toAggregate(busEntity.get()));
    }

    @Override
    public Optional<BusAggregate> getByRegistrationPlate(String registrationPlate) {
        Optional<BusEntity> busEntity = busRepository.findByRegistrationPlate(registrationPlate);
        if (busEntity.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(busEntityMapper.toAggregate(busEntity.get()));
    }

    @Override
    public List<BusEntity> findByActive(Boolean active) {
        List<BusEntity> busEntities = busRepository.findByActive(active);
        if (busEntities.isEmpty()) {
            return Collections.emptyList();
        }
        return busEntities;
    }

    @Override
    public BusAggregate save(BusAggregate busAggregate) {
        BusEntity busEntity = busEntityMapper.toEntity(busAggregate);
        busEntity = repositoryExecutor.saveAggregate(busEntity, busRepository);
        return busEntityMapper.toAggregate(busEntity);
    }

    @Override
    public Optional<BusAggregate> getByUuid(String uuid) {
        Optional<BusEntity> busEntity = busRepository.findByUuid(uuid);
        if (busEntity.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(busEntityMapper.toAggregate(busEntity.get()));
    }
}
