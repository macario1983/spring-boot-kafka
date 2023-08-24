package com.springboot.kafka.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Setter
public class AlunoDTO {

    private UUID id;

    private String nome;

    private int idade;

    private String email;

    private String sexo;

    private LocalDateTime dataInsercao;

    private LocalDateTime dataAlteracao;

}
