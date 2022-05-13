package br.com.matheus.ibmprovatecnica.domain.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Compra {

    private String codigo;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date data;
    private String cliente;
    private List<Produto> itens;
    private BigDecimal valorTotal;
}
