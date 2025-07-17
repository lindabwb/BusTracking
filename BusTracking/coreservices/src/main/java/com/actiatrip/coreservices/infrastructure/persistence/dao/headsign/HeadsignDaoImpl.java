package com.actiatrip.coreservices.infrastructure.persistence.dao.headsign;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.actiatrip.coreservices.application.domaine.aggregat.HeadsignAggregate;
import com.actiatrip.coreservices.application.service.headsign.HeadsignDao;
import com.actiatrip.coreservices.infrastructure.entities.HeadsignEntity;
import com.actiatrip.coreservices.infrastructure.persistence.dao.JpaRepositoryExecutor;
import com.actiatrip.coreservices.infrastructure.persistence.mapper.HeadsignEntityMapper;
import com.actiatrip.coreservices.infrastructure.persistence.repository.HeadsignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeadsignDaoImpl implements HeadsignDao {

    @Autowired
    private HeadsignRepository headsignRepository;

    @Autowired
    private HeadsignEntityMapper headsignEntityMapper;

    @Autowired
    private JpaRepositoryExecutor repositoryExecutor; // need the JpaRepositoryExecutor class

    @Override
    public List<HeadsignAggregate> getAll() {
        List<HeadsignEntity> headsignEntities = headsignRepository.findAll();
        if (headsignEntities.isEmpty()) {
            return Collections.emptyList();
        }
        return headsignEntityMapper.toListAggregates(headsignEntities);
    }

    @Override
    public Optional<HeadsignAggregate> getBySerialNumberAndModel(String serialNumber, String model) {
        Optional<HeadsignEntity> headsignEntity =
                headsignRepository.findBySerialNumberAndModel(serialNumber, model);
        if (headsignEntity.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(headsignEntityMapper.toAggregate(headsignEntity.get()));
    }

    @Override
    public HeadsignAggregate save(HeadsignAggregate headsignAggregate) {
        HeadsignEntity headsignEntity = headsignEntityMapper.toEntity(headsignAggregate);
        headsignEntity = repositoryExecutor.saveAggregate(headsignEntity, headsignRepository); // need the JpaRepositoryExecutor class
        return headsignEntityMapper.toAggregate(headsignEntity);
    }

    @Override
    public Optional<HeadsignAggregate> getByUuid(String uuid) {
        Optional<HeadsignEntity> headsignEntity = headsignRepository.findByUuid(uuid);
        if (headsignEntity.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(headsignEntityMapper.toAggregate(headsignEntity.get()));
    }
}

