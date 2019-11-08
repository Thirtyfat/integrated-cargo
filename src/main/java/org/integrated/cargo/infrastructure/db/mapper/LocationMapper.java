package org.integrated.cargo.infrastructure.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.integrated.cargo.infrastructure.db.dataobject.LocationDO;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface LocationMapper {

    LocationDO select(@Param("code") String code);

    List<LocationDO> selectAll();


}
