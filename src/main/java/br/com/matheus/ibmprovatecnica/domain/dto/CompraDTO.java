package br.com.matheus.ibmprovatecnica.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CompraDTO {

    private String codigo;
    private Date data;
    private String cliente;
    private List<ProdutoDTO> itens;
    private BigDecimal valorTotal;
}