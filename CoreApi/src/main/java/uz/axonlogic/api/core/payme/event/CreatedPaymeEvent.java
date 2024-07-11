package uz.axonlogic.api.core.payme.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class CreatedPaymeEvent implements Serializable {


    private String paymentId;
    private String name;
    private String orderId;

}