package com.springboot.kafka.controller;

import com.springboot.kafka.dto.AlunoDTO;
import com.springboot.kafka.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RequestMapping("/alunos")
@RequiredArgsConstructor
@RestController
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoDTO> insert(@RequestBody @Valid AlunoDTO alunoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.send(alunoDTO));
    }

}
