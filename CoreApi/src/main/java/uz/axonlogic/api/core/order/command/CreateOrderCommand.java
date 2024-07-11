package uz.axonlogic.api.core.order.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class CreateOrderCommand  {

    @TargetAggregateIdentifier
    private String orderId;
    private String name;
}