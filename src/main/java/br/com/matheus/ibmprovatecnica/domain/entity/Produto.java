package br.com.matheus.ibmprovatecnica.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Produto {

        private String nome;
        private String variedade;
        private String pais;
        private String categoria;
        private Integer safra;
        private BigDecimal preco;

    public Produto(String nome, String variedade, String pais, String categoria, Integer safra, BigDecimal preco) {
        this.nome = nome;
        this.variedade = variedade;
        this.pais = pais;
        this.categoria = categoria;
        this.safra = safra;
        this.preco = preco;
    }
}
