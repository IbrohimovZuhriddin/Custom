package uz.axonlogic.api.core.payme.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CreatePaymeCommand implements Serializable {

    @TargetAggregateIdentifier
    private String paymentId;
    private String name;
}