package org.integrated.cargo.application.query;

import org.integrated.cargo.application.query.dto.CargoHandlingEventDTO;
import org.integrated.cargo.application.query.qry.EventFindbyCargoQry;

public interface TrackQueryService {
    
    CargoHandlingEventDTO queryHistory(EventFindbyCargoQry qry);


}
