package br.com.matheus.ibmprovatecnica.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoDTO {
    private String nome;
    private String variedade;
    private String pais;
    private String categoria;
    private Integer safra;
    private BigDecimal preco;
}
