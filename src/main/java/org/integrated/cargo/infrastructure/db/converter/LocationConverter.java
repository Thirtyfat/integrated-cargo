package org.integrated.cargo.infrastructure.db.converter;

import org.integrated.cargo.domain.aggregate.location.Location;
import org.integrated.cargo.infrastructure.db.dataobject.LocationDO;
import org.springframework.beans.BeanUtils;

public class LocationConverter {

    public static LocationDO serialize(Location location) {
        LocationDO target = new LocationDO();
        BeanUtils.copyProperties(location, target);
        return target;
    }

    public static Location deserialize(LocationDO locationDO) {
        Location target = new Location();
        BeanUtils.copyProperties(locationDO, target);
        return target;
    }

}
