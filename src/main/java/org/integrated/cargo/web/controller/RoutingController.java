package org.integrated.cargo.web.controller;

import org.integrated.cargo.application.query.RoutingQueryService;
import org.integrated.cargo.application.query.dto.CarrierMovementDTO;
import org.integrated.cargo.infrastructure.db.dataobject.LocationDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/routing")
public class RoutingController {

    @Autowired
    private RoutingQueryService routingQueryService;

    @RequestMapping(value = "/carrier", method = RequestMethod.GET)
    public List<CarrierMovementDTO> carriers() {
        return routingQueryService.queryCarriers();
    }

    @RequestMapping(value = "/location", method = RequestMethod.GET)
    public List<LocationDO> locations() {
        return routingQueryService.queryLocations();
    }

}
