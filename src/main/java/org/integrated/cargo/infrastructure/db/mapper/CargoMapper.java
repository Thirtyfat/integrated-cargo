package org.integrated.cargo.infrastructure.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.integrated.cargo.infrastructure.db.dataobject.CargoDO;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CargoMapper {

    CargoDO select(@Param("id") String id);

    List<CargoDO> selectAll();

    List<CargoDO> selectByCustomer(@Param("phone") String phone);

    void save(CargoDO cargoDO);
    
    void update(CargoDO cargoDO);

    void remove(@Param("id") String id);

    int countByCustomer(@Param("phone") String phone);


}
