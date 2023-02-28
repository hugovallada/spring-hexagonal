package com.github.hugovallada.hexagonal.adapters.in.consumer;

import com.github.hugovallada.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.github.hugovallada.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.github.hugovallada.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final CustomerMessageMapper mapper;

    public ReceiveValidatedCpfConsumer(UpdateCustomerInputPort updateCustomerInputPort, CustomerMessageMapper mapper) {
        this.updateCustomerInputPort = updateCustomerInputPort;
        this.mapper = mapper;
    }

    @KafkaListener(topics = "tp-cpf-validated", groupId = "hlvl")
    public void execute(CustomerMessage customerMessage) {
        var customer = mapper.toCustomer(customerMessage);
        updateCustomerInputPort.execute(customer, customerMessage.zipCode());
    }
}
