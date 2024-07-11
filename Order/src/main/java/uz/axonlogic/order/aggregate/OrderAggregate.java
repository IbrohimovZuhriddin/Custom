package uz.axonlogic.order.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import uz.axonlogic.api.core.order.command.CreateOrderCommand;
import uz.axonlogic.api.core.order.event.CreatedOrderEvent;

import uz.axonlogic.api.core.payme.command.PaymentSuccessfullyFinishedCommand;
import uz.axonlogic.api.core.payme.event.PaymentSuccessfullyFinishedEvent;

@Aggregate
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;
    private String name;

    public OrderAggregate() {}

    @CommandHandler
    public OrderAggregate(CreateOrderCommand command){

    // order berildi
//        System.out.println("CreateOrderCommand  OrderAggregate "+command);

        AggregateLifecycle.apply ( new CreatedOrderEvent ( command.getOrderId(), command.getName() ) ); // event yozildi
    }

    @EventSourcingHandler  //yozilgandan keyingi holatni yangilash uchun kerak
    public void on ( CreatedOrderEvent createdOrderEvent){
        this.orderId = createdOrderEvent.getOrderId();
        this.name = createdOrderEvent.getName();
    }


//    @CommandHandler
//    public void successfullyFinishedPaid(PaymentSuccessfullyFinishedCommand paymentSuccessfullyFinishedCommand) {
//
//        AggregateLifecycle.apply (new PaymentSuccessfullyFinishedEvent(paymentSuccessfullyFinishedCommand.getOrderId(), paymentSuccessfullyFinishedCommand.getName() ) );
////        System.out.println("O'tdi");
//    }
//
//    @EventSourcingHandler
//    public void on (PaymentSuccessfullyFinishedEvent paymentSuccessfullyFinishedEvent){
//        this.orderId= paymentSuccessfullyFinishedEvent.getPaymentId();
//        this.name=paymentSuccessfullyFinishedEvent.getName();
//    }

}