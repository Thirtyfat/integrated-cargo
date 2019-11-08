package org.integrated.cargo.infrastructure.event.comsumer;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.integrated.cargo.application.command.CargoCmdService;
import org.integrated.cargo.domain.aggregate.cargo.CargoBookDomainEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CargoListener {
    
    @Autowired
    private CargoCmdService cargoCmdService;
    @Autowired
    private EventBus eventBus;
    
    @PostConstruct
    public void init(){
        eventBus.register(this);
    }

    @Subscribe
    public void recordCargoBook(CargoBookDomainEvent event) {
        // invoke application service or domain service
        System.out.println("CargoListener: recordCargoBook......");
    }
}
