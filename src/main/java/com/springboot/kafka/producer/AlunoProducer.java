package com.springboot.kafka.producer;

import com.springboot.kafka.dto.AlunoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@Service
@Slf4j
public class AlunoProducer {

    private final KafkaTemplate<String, AlunoDTO> kafkaTemplate;

    public AlunoDTO send(AlunoDTO alunoDTO) {

        try {
            SendResult<String, AlunoDTO> sendResult = kafkaTemplate.send("aluno", alunoDTO.getId().toString(), alunoDTO).get();
            AlunoDTO record = sendResult.getProducerRecord().value();
            log.info("Mensagem enviada com sucesso: {}", record.getId());
            return record;
        } catch (InterruptedException | ExecutionException e) {
            log.error("Erro ao enviar a mensagem: {}", e.getMessage());
        }
        
        return null;
    }
}
