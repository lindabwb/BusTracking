package com.actiatrip.coreservices.application.service.bus;

import com.actiatrip.coreservices.application.domaine.aggregat.BusAggregate;
import com.actiatrip.coreservices.application.error.exception.business.BusinessException;
import com.actiatrip.coreservices.application.error.exception.business.NotFoundException;
import com.actiatrip.coreservices.application.error.exception.business.SivIllegalArgumentException;
import com.actiatrip.coreservices.application.error.exception.technical.TechnicalException;

import java.util.List;
import java.util.Optional;

import com.actiatrip.coreservices.application.service.bus.BusDao;
import com.actiatrip.coreservices.application.service.bus.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusDao busDao;

    @Override
    public List<BusAggregate> getAll() {
        List<BusAggregate> busAggregates;
        try {
            busAggregates = busDao.getAll();
        } catch (Exception e) {
            throw new TechnicalException("An error occurred");
        }
        return busAggregates;
    }

    @Override
    public BusAggregate add(BusAggregate bus) {
        if (bus == null) {
            throw new BusinessException("bus should not be null");
        }

        String registrationPlate = bus.getRegistrationPlate();
        String trackingDeviceId = bus.getTrackingDeviceId();
        Boolean status = bus.getActive();

        if (!StringUtils.hasLength(registrationPlate)) {
            throw new BusinessException("registration plate should not be null");
        }

        if (!StringUtils.hasLength(trackingDeviceId)) {
            throw new BusinessException("tracking device id should not be null");
        }

        Optional<BusAggregate> bussigndb = busDao.getByRegistrationPlate(registrationPlate);
        if (bussigndb.isPresent()) {
            throw new BusinessException("bus with registration plate = " + registrationPlate + " already exists");
        }

        return busDao.save(bus);
    }

    @Transactional(readOnly = true)
    @Override
    public BusAggregate getById(String id) {
        if (!StringUtils.hasLength(id)) {
            throw new SivIllegalArgumentException("id should not be empty");
        }

        Optional<BusAggregate> busAggregate = busDao.getByUuid(id);
        if (busAggregate.isEmpty()) {
            throw new NotFoundException("no bus exists with uuid : " + id);
        }

        return busAggregate.get();
    }
}
