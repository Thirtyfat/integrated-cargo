package org.integrated.cargo.infrastructure.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.integrated.cargo.infrastructure.db.dataobject.CarrierMovementDO;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CarrierMovementMapper {

    CarrierMovementDO select(@Param("scheduleId") String scheduleId);

    List<CarrierMovementDO> selectAll();


}
