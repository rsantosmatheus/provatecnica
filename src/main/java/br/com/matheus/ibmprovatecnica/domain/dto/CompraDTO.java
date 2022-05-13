package br.com.matheus.ibmprovatecnica.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CompraDTO {

    private String codigo;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date data;
    private String cliente;
    private List<ProdutoDTO> itens;
    private BigDecimal valorTotal;
}