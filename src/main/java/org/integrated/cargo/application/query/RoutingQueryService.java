package org.integrated.cargo.application.query;

import org.integrated.cargo.application.query.dto.CarrierMovementDTO;
import org.integrated.cargo.infrastructure.db.dataobject.LocationDO;

import java.util.List;

public interface RoutingQueryService {

    List<CarrierMovementDTO> queryCarriers();
    List<LocationDO> queryLocations();

}
