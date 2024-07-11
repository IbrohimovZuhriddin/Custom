package uz.axonlogic.payment.saga;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.axonlogic.api.core.payme.command.PaymentSuccessfullyFinishedCommand;
import uz.axonlogic.api.core.payme.event.CreatedPaymeEvent;

import java.util.UUID;

@Component
public class PaymentSuccessSaga {

    @Autowired
    private CommandGateway commandGateway;

//    @EventHandler
//    public void on( CreatedPaymeEvent createdPaymeEvent ){
//        commandGateway.send ( new PaymentSuccessfullyFinishedCommand (createdPaymeEvent.getPaymentId(), createdPaymeEvent.getOrderId(), createdPaymeEvent.getName() ));
//        System.out.println("Keldi");
//    }
}