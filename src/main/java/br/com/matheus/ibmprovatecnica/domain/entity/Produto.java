package br.com.matheus.ibmprovatecnica.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private String codigo;
    private String produto;
    private String variedade;
    private String pais;
    private String categoria;
    private Integer safra;
    private BigDecimal preco;
}
