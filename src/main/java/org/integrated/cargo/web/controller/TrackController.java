package org.integrated.cargo.web.controller;


import org.integrated.cargo.application.query.TrackQueryService;
import org.integrated.cargo.application.query.dto.CargoHandlingEventDTO;
import org.integrated.cargo.application.query.qry.EventFindbyCargoQry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/track")
public class TrackController {

    @Autowired
    private TrackQueryService trackQueryService;

    @RequestMapping(value = "/{cargoId}", method = RequestMethod.GET)
    public CargoHandlingEventDTO query(@PathVariable String cargoId) {
        EventFindbyCargoQry qry = new EventFindbyCargoQry();
        qry.setCargoId(cargoId);
        return trackQueryService.queryHistory(qry);
    }

}
