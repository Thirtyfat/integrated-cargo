package org.integrated.cargo.application.command;


import org.integrated.cargo.application.command.cmd.CargoBookCommand;
import org.integrated.cargo.application.command.cmd.CargoDeleteCommand;
import org.integrated.cargo.application.command.cmd.CargoDeliveryUpdateCommand;
import org.integrated.cargo.application.command.cmd.CargoSenderUpdateCommand;

public interface CargoCmdService {
    
    void bookCargo(CargoBookCommand cargoBookCommand);

    void updateCargoDelivery(CargoDeliveryUpdateCommand cmd);

    void deleteCargo(CargoDeleteCommand cmd);

    void updateCargoSender(CargoSenderUpdateCommand cmd);

}
