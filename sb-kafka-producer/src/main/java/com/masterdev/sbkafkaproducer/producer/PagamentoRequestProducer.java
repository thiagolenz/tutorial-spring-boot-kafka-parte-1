package com.masterdev.sbkafkaproducer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.masterdev.sbkafkaproducer.dto.PagamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PagamentoRequestProducer {
    @Value("${topicos.pagamento.request.topic}")
    private String topicoPagamentoRequest;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String sendMessage(PagamentoDTO pagamento) throws JsonProcessingException {
        String conteudo = objectMapper.writeValueAsString(pagamento);
        kafkaTemplate.send(topicoPagamentoRequest, conteudo);
        return "Pagamento enviado para processamento";
    }
}
