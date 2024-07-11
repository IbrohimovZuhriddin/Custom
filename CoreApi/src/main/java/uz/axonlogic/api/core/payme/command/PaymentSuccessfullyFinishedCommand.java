package uz.axonlogic.api.core.payme.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Data
@Getter
@AllArgsConstructor
public class PaymentSuccessfullyFinishedCommand implements Serializable {

    @TargetAggregateIdentifier
    private String paymentId;
    private String orderId;
    private String name;
    //   orderni payment bolgandan keyingi sotish logikalari


}