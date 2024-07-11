package uz.axonlogic.payment.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import uz.axonlogic.api.core.payme.command.CreatePaymeCommand;
import uz.axonlogic.api.core.payme.event.CreatedPaymeEvent;

import java.util.UUID;

@Aggregate
public class PaymeAggregate {

    @AggregateIdentifier
    private String paymentId;
    private String name;

    public PaymeAggregate() {}

    @CommandHandler
    public PaymeAggregate ( CreatePaymeCommand createPaymeCommand ) {

        // logika payme pul yechish
//        System.out.println("CreatePaymeCommand Payme Aggregate" + createPaymeCommand );

        AggregateLifecycle.apply ( new CreatedPaymeEvent ( UUID.randomUUID().toString(), createPaymeCommand.getPaymentId(), createPaymeCommand.getName() ));
        // pul yechilganini event qilib yozdik
        // event busga jo'natildi.
    }

    @EventSourcingHandler
    public void on(CreatedPaymeEvent createdPaymeEvent) {
        this.paymentId = createdPaymeEvent.getPaymentId();
        this.name = createdPaymeEvent.getName();
    }
}