package org.integrated.cargo.infrastructure.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.integrated.cargo.infrastructure.db.dataobject.HandlingEventDO;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface HandlingEventMapper {

    List<HandlingEventDO> selectByCargo(@Param("cargoId") String cargoId);

    List<HandlingEventDO> selectByScheduleId(@Param("scheduleId") String scheduleId);

    void save(HandlingEventDO handlingEventDO);

}
