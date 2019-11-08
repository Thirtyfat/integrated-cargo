package org.integrated.cargo.infrastructure.db.converter;

import org.integrated.cargo.domain.aggregate.handlingevent.EventTypeEnum;
import org.integrated.cargo.domain.aggregate.handlingevent.HandlingEvent;
import org.integrated.cargo.infrastructure.db.dataobject.HandlingEventDO;

public class HandlingEventConverter {

    public static HandlingEventDO serialize(HandlingEvent location) {
        HandlingEventDO target = new HandlingEventDO();
        target.setId(location.id());
        target.setCargoId(location.cargoId());
        target.setDatetime(location.datetime());
        target.setScheduleId(location.scheduleId());
        target.setEventType(location.eventType().index());
        return target;
    }

    public static HandlingEvent deserialize(HandlingEventDO locationDO) {
        return HandlingEvent.newHandlingEvent(locationDO.getId(),
                locationDO.getCargoId(), locationDO.getDatetime(),
                EventTypeEnum.of(locationDO.getEventType()), locationDO.getScheduleId());
    }

}
