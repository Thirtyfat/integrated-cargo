package org.integrated.cargo.domain.aggregate.handlingevent;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HandlingEventRepository {

    List<HandlingEvent> findByCargo(String cargoId);

    List<HandlingEvent> findByScheduleId(String scheduleId);

    void save(HandlingEvent handlingEvent);

}
