package org.integrated.cargo.infrastructure.db.converter;

import org.integrated.cargo.domain.aggregate.carriermovement.CarrierMovement;
import org.integrated.cargo.infrastructure.db.dataobject.CarrierMovementDO;
import org.springframework.beans.BeanUtils;

public class CarrierMovementConverter {

    public static CarrierMovementDO serialize(CarrierMovement location) {
        CarrierMovementDO target = new CarrierMovementDO();
        BeanUtils.copyProperties(location, target);
        return target;
    }

    public static CarrierMovement deserialize(CarrierMovementDO locationDO) {
        CarrierMovement target = new CarrierMovement();
        BeanUtils.copyProperties(locationDO, target);
        return target;
    }

}
