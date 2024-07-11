package uz.axonlogic.order.saga;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.axonlogic.api.core.order.event.CreatedOrderEvent;
import uz.axonlogic.api.core.payme.command.CreatePaymeCommand;

@Component //saga
public class ReservationOrderSuccess {

    @Autowired
    private CommandGateway commandGateway;

    @EventHandler
    public void handle(CreatedOrderEvent createdOrderEvent) {
//        System.out.println("CreatedOrderEvent " + createdOrderEvent);
        commandGateway.sendAndWait (new CreatePaymeCommand( createdOrderEvent.getOrderId(), createdOrderEvent.getName()));
    }
}