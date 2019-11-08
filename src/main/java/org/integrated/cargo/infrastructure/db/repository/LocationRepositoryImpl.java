package org.integrated.cargo.infrastructure.db.repository;

import org.integrated.cargo.domain.aggregate.location.Location;
import org.integrated.cargo.domain.aggregate.location.LocationRepository;
import org.integrated.cargo.infrastructure.db.converter.LocationConverter;
import org.integrated.cargo.infrastructure.db.dataobject.LocationDO;
import org.integrated.cargo.infrastructure.db.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationRepositoryImpl implements LocationRepository {

    @Autowired
    private LocationMapper mapper;

    @Override
    public Location find(String code) {
        LocationDO locationDO = mapper.select(code);
        return LocationConverter.deserialize(locationDO);
    }

}
