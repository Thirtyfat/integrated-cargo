package org.integrated.cargo.infrastructure.db.converter;

import org.integrated.cargo.domain.aggregate.cargo.Cargo;
import org.integrated.cargo.domain.aggregate.cargo.valueobject.DeliverySpecification;
import org.integrated.cargo.infrastructure.db.dataobject.CargoDO;

public class CargoConverter {

    public static CargoDO serialize(Cargo cargo) {
        CargoDO target = new CargoDO();
        target.setId(cargo.id());
        target.setSenderPhone(cargo.sender());
        target.setDescription(cargo.description());
        DeliverySpecification delivery = cargo.delivery();
        target.setDestinationLocationCode(delivery.getDestinationLocationCode());
        target.setOriginLocationCode(delivery.getOriginLocationCode());
        return target;
    }

    public static Cargo deserialize(CargoDO cargo) {
        return Cargo.newCargo(cargo.getId(), cargo.getSenderPhone(), cargo.getDescription(),
                new DeliverySpecification(cargo.getOriginLocationCode(),
                        cargo.getDestinationLocationCode()));
    }

}
