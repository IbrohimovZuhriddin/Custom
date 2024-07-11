package uz.axonlogic.order.rest;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.axonlogic.api.core.order.command.CreateOrderCommand;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/orders")
public class OrderCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping("/create")
    public CompletableFuture<Object> createOrder ( @RequestBody CreateOrderCommand command) {
    return commandGateway.send(command);  }
}