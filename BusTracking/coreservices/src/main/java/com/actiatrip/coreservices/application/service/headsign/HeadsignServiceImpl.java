package com.actiatrip.coreservices.application.service.headsign;

import com.actiatrip.coreservices.application.domaine.aggregat.HeadsignAggregate;
import com.actiatrip.coreservices.application.error.exception.business.BusinessException;
import com.actiatrip.coreservices.application.error.exception.business.NotFoundException;
import com.actiatrip.coreservices.application.error.exception.business.SivIllegalArgumentException;
import com.actiatrip.coreservices.application.error.exception.technical.TechnicalException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class HeadsignServiceImpl implements HeadsignService {

    @Autowired
    private HeadsignDao headsignDao;

    @Override
    public List<HeadsignAggregate> getAll() {
        List<HeadsignAggregate> headsignAggregates;
        try {
            headsignAggregates = headsignDao.getAll();
        } catch (Exception e) {
            throw new TechnicalException("An error occurred");
        }
        return headsignAggregates;
    }

    @Override
    public HeadsignAggregate add(HeadsignAggregate headsign) {
        if (headsign == null) {
            throw new BusinessException("headsign should not be null");
        }

        String serialNumber = headsign.getSerialNumber();
        String model = headsign.getModel();

        if (!StringUtils.hasLength(serialNumber)) {
            throw new BusinessException("serial number should not be null");
        }

        if (!StringUtils.hasLength(model)) {
            throw new BusinessException("model should not be null");
        }

        Optional<HeadsignAggregate> headsigndb = headsignDao.getBySerialNumberAndModel(serialNumber, model);
        if (headsigndb.isPresent()) {
            throw new BusinessException("headsign with serial number = " + serialNumber + " and model = " + model + " already exist");
        }

        return headsignDao.save(headsign);
    }

    @Transactional(readOnly = true)
    @Override
    public HeadsignAggregate getById(String id) {
        if (!StringUtils.hasLength(id)) {
            throw new SivIllegalArgumentException("id should not be empty");
        }

        Optional<HeadsignAggregate> headsignAggregate = headsignDao.getByUuid(id);
        if (headsignAggregate.isEmpty()) {
            throw new NotFoundException("no headsign exist with uuid : " + id);
        }

        return headsignAggregate.get();
    }
}
