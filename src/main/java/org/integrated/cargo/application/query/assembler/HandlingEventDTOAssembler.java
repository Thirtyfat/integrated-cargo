package org.integrated.cargo.application.query.assembler;

import org.integrated.cargo.application.query.dto.CarrierMovementDTO;
import org.integrated.cargo.application.query.dto.HandlingEventDTO;
import org.integrated.cargo.domain.aggregate.handlingevent.EventTypeEnum;
import org.integrated.cargo.infrastructure.db.dataobject.CarrierMovementDO;
import org.integrated.cargo.infrastructure.db.dataobject.HandlingEventDO;
import org.integrated.cargo.infrastructure.db.mapper.CarrierMovementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.function.Function;

@Component
public class HandlingEventDTOAssembler implements Function<HandlingEventDO, HandlingEventDTO> {

    @Autowired
    private CarrierMovementMapper carrierMovementMapper;
    @Autowired
    private CarrierMovementDTOAssembler converter;

    @Override
    public HandlingEventDTO apply(HandlingEventDO t) {
        HandlingEventDTO target = new HandlingEventDTO();
        target.setEventType(String.valueOf(EventTypeEnum.of(t.getEventType())));
        target.setDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(t.getDatetime()));

        if (!StringUtils.isEmpty(t.getScheduleId())) {
            CarrierMovementDO carrierMovementDO = carrierMovementMapper.select(t.getScheduleId());
            CarrierMovementDTO carrierMovement = converter.apply(carrierMovementDO);
            target.setCarrierMovement(carrierMovement);
        }
        return target;
    }

}
