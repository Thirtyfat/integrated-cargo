package org.integrated.cargo;

import com.google.common.eventbus.EventBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IntegratedCargoApplication {


    @Bean
    public EventBus configEvent() {
        return new EventBus();
    }

    public static void main(String[] args) {
        SpringApplication.run(IntegratedCargoApplication.class, args);
    }

}
