package org.integrated.cargo.application.query.impl;

import org.integrated.cargo.application.query.TrackQueryService;
import org.integrated.cargo.application.query.assembler.CargoDTOAssembler;
import org.integrated.cargo.application.query.assembler.HandlingEventDTOAssembler;
import org.integrated.cargo.application.query.dto.CargoDTO;
import org.integrated.cargo.application.query.dto.CargoHandlingEventDTO;
import org.integrated.cargo.application.query.dto.HandlingEventDTO;
import org.integrated.cargo.application.query.qry.EventFindbyCargoQry;
import org.integrated.cargo.infrastructure.db.dataobject.CargoDO;
import org.integrated.cargo.infrastructure.db.dataobject.HandlingEventDO;
import org.integrated.cargo.infrastructure.db.mapper.CargoMapper;
import org.integrated.cargo.infrastructure.db.mapper.HandlingEventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrackQueryServiceImpl implements TrackQueryService {

    @Autowired
    private HandlingEventMapper handlingEventMapper;

    @Autowired
    private CargoMapper cargoMapper;

    @Autowired
    private CargoDTOAssembler converter;
    @Autowired
    private HandlingEventDTOAssembler handlingEventDTOAssembler;

    @Override
    public CargoHandlingEventDTO queryHistory(EventFindbyCargoQry qry) {

        CargoDO cargo = cargoMapper.select(qry.getCargoId());
        List<HandlingEventDO> events = handlingEventMapper.selectByCargo(qry.getCargoId());

        // convertor
        CargoDTO cargoDTO = converter.apply(cargo);
        List<HandlingEventDTO> dtoEvents = events.stream().map(handlingEventDTOAssembler)
                .collect(Collectors.toList());

        CargoHandlingEventDTO cargoHandlingEventDTO = new CargoHandlingEventDTO();
        cargoHandlingEventDTO.setCargo(cargoDTO);
        cargoHandlingEventDTO.setEvents(dtoEvents);

        return cargoHandlingEventDTO;
    }

}
