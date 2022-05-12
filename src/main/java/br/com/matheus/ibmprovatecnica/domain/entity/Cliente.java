package br.com.matheus.ibmprovatecnica.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Cliente {

    private Long id;
    private String nome;
    private String cpf;
}