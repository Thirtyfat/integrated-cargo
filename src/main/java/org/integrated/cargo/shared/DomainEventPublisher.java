package org.integrated.cargo.shared;

import org.springframework.stereotype.Component;

public interface DomainEventPublisher {
    public void publish(Object event);

}
