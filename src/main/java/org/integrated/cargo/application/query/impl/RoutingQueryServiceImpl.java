package org.integrated.cargo.application.query.impl;

import org.integrated.cargo.application.query.RoutingQueryService;
import org.integrated.cargo.application.query.assembler.CarrierMovementDTOAssembler;
import org.integrated.cargo.application.query.dto.CarrierMovementDTO;
import org.integrated.cargo.infrastructure.db.dataobject.CarrierMovementDO;
import org.integrated.cargo.infrastructure.db.dataobject.LocationDO;
import org.integrated.cargo.infrastructure.db.mapper.CarrierMovementMapper;
import org.integrated.cargo.infrastructure.db.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoutingQueryServiceImpl implements RoutingQueryService {

    @Autowired
    private CarrierMovementMapper carrierMovementMapper;
    @Autowired
    private LocationMapper locationMapper;
    @Autowired
    private CarrierMovementDTOAssembler converter;

    @Override
    public List<CarrierMovementDTO> queryCarriers() {
        List<CarrierMovementDO> carrierMovementDOs = carrierMovementMapper.selectAll();
        return carrierMovementDOs.stream().map(converter).collect(Collectors.toList());
    }

    @Override
    public List<LocationDO> queryLocations() {
        return locationMapper.selectAll();
    }

}
