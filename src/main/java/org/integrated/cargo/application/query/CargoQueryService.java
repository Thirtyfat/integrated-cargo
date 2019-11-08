package org.integrated.cargo.application.query;

import org.integrated.cargo.application.query.dto.CargoDTO;
import org.integrated.cargo.application.query.qry.CargoFindbyCustomerQry;

import java.util.List;

public interface CargoQueryService {

    List<CargoDTO> queryCargos();

    List<CargoDTO> queryCargos(CargoFindbyCustomerQry qry);

    CargoDTO getCargo(String cargoId);

}
