package org.integrated.cargo.application.query.assembler;

import org.integrated.cargo.application.query.dto.CargoDTO;
import org.integrated.cargo.infrastructure.db.dataobject.CargoDO;
import org.integrated.cargo.infrastructure.db.dataobject.LocationDO;
import org.integrated.cargo.infrastructure.db.mapper.LocationMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CargoDTOAssembler implements Function<CargoDO, CargoDTO> {

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public CargoDTO apply(CargoDO t) {
        CargoDTO target = new CargoDTO();
        BeanUtils.copyProperties(t, target);
        LocationDO select = locationMapper.select(t.getOriginLocationCode());
        target.setOriginLocationName(select.getName());
        select = locationMapper.select(t.getDestinationLocationCode());
        target.setDestinationLocationName(select.getName());
        return target;
    }

}
