package org.integrated.cargo.infrastructure.db.repository;

import org.integrated.cargo.domain.aggregate.carriermovement.CarrierMovement;
import org.integrated.cargo.domain.aggregate.carriermovement.CarrierMovementRepository;
import org.integrated.cargo.infrastructure.db.converter.CarrierMovementConverter;
import org.integrated.cargo.infrastructure.db.dataobject.CarrierMovementDO;
import org.integrated.cargo.infrastructure.db.mapper.CarrierMovementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarrierMovementRepositoryImpl implements CarrierMovementRepository {

    @Autowired
    private CarrierMovementMapper mapper;

    @Override
    public CarrierMovement find(String id) {
        CarrierMovementDO carrierMovementDO = mapper.select(id);
        return CarrierMovementConverter.deserialize(carrierMovementDO);
    }

}
