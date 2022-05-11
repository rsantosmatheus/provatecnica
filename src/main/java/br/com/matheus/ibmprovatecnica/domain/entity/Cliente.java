package br.com.matheus.ibmprovatecnica.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {

    private Long id;
    private String nome;
    private String cpf;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }
}
