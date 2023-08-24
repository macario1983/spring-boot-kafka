package com.springboot.kafka.service;

import com.springboot.kafka.dto.AlunoDTO;
import com.springboot.kafka.producer.AlunoProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@Service
@Slf4j
public class AlunoService {

    private final AlunoProducer alunoProducer;

    public AlunoDTO send(AlunoDTO alunoDTO) {
        return alunoProducer.send(alunoDTO);
    }
}
