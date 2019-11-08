package org.integrated.cargo.web.controller;


import org.integrated.cargo.application.command.CargoCmdService;
import org.integrated.cargo.application.command.cmd.CargoBookCommand;
import org.integrated.cargo.application.command.cmd.CargoDeleteCommand;
import org.integrated.cargo.application.command.cmd.CargoDeliveryUpdateCommand;
import org.integrated.cargo.application.command.cmd.CargoSenderUpdateCommand;
import org.integrated.cargo.application.query.CargoQueryService;
import org.integrated.cargo.application.query.dto.CargoDTO;
import org.integrated.cargo.application.query.qry.CargoFindbyCustomerQry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    CargoQueryService cargoQueryService;
    @Autowired
    CargoCmdService cargoCmdService;

    @RequestMapping(method = RequestMethod.GET)
    public List<CargoDTO> queryCargos(
            @RequestParam(value = "phone", required = false) String phone) {
        if (!StringUtils.isEmpty(phone)) {
            CargoFindbyCustomerQry qry = new CargoFindbyCustomerQry();
            qry.setCustomerPhone(phone);
            return cargoQueryService.queryCargos(qry);
        }
        return cargoQueryService.queryCargos();
    }
    
    @RequestMapping(value = "/{cargoId}", method = RequestMethod.GET)
    public CargoDTO cargo(@PathVariable String cargoId) {
        return cargoQueryService.getCargo(cargoId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void book(@RequestBody CargoBookCommand cargoBookCommand) {
        cargoCmdService.bookCargo(cargoBookCommand);
    }

    @RequestMapping(value = "/{cargoId}/delivery", method = RequestMethod.PUT)
    public void modifydestinationLocationCode(@PathVariable String cargoId,
            @RequestBody CargoDeliveryUpdateCommand cmd) {
        cmd.setCargoId(cargoId);
        cargoCmdService.updateCargoDelivery(cmd);
    }
    @RequestMapping(value = "/{cargoId}/sender", method = RequestMethod.PUT)
    public void modifySender(@PathVariable String cargoId,
            @RequestBody CargoSenderUpdateCommand cmd) {
        cmd.setCargoId(cargoId);
        cargoCmdService.updateCargoSender(cmd);
    }

    @RequestMapping(value = "/{cargoId}", method = RequestMethod.DELETE)
    public void remoeCargo(@PathVariable String cargoId) {
        CargoDeleteCommand cmd = new CargoDeleteCommand();
        cmd.setCargoId(cargoId);
        cargoCmdService.deleteCargo(cmd);
    }

}
