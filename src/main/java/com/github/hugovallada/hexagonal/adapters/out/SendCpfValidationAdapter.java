package com.github.hugovallada.hexagonal.adapters.out;

import com.github.hugovallada.hexagonal.application.ports.out.SendCpfForValidationOutputPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCpfValidationAdapter implements SendCpfForValidationOutputPort {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public SendCpfValidationAdapter(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void execute(String cpf) {
        kafkaTemplate.send("tp-cpf-validatiion", cpf);
    }
}
