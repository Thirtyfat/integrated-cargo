package org.integrated.cargo.application.command.impl;

import org.integrated.cargo.application.command.IncidentLoggingCmdService;
import org.integrated.cargo.application.command.cmd.HandlingEventAddCommand;
import org.integrated.cargo.domain.aggregate.handlingevent.EventTypeEnum;
import org.integrated.cargo.domain.aggregate.handlingevent.HandlingEvent;
import org.integrated.cargo.domain.aggregate.handlingevent.HandlingEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IncidentLoggingCmdServiceImpl implements IncidentLoggingCmdService {

    @Autowired
    private HandlingEventRepository handlingEventRepository;

    @Override
    public void addHandlingEvent(HandlingEventAddCommand cmd) {
        // validate

        // create
        HandlingEvent handlingEvent = HandlingEvent.newHandlingEvent(cmd.getCargoId(),
                cmd.getDatetime(), EventTypeEnum.of(cmd.getEventType()), cmd.getScheduleId());

        // save
        handlingEventRepository.save(handlingEvent);

    }

}
