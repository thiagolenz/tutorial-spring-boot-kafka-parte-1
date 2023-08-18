package com.masterdev.sbkafkaconsumer.consumidor;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PagamentoRequestConsumer {

    @KafkaListener(
        topics = "${topicos.pagamento.request.topic}",
        groupId = "pagamento-request-consumer-1"
    )
    public void consume(String message) {
        System.out.println("===== MENSAGEM RECEBIDA === " + message);
    }
}
