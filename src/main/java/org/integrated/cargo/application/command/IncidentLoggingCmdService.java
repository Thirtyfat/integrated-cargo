package org.integrated.cargo.application.command;


import org.integrated.cargo.application.command.cmd.HandlingEventAddCommand;

public interface IncidentLoggingCmdService {

    void addHandlingEvent(HandlingEventAddCommand cmd);

}
