package uz.axonlogic.api.core.order.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CreatedOrderEvent  implements Serializable {


    private String orderId;
    private String name;

}