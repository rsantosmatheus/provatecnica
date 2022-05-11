package br.com.matheus.ibmprovatecnica.domain.entity;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Compra {

    private String codigo;
    private Date data;
    private String cliente;
    private List<Produto> itens;
    private BigDecimal valorTotal;

    public Compra() {
    }

    public Compra(String codigo, Date data, String cliente, List<Produto> itens, BigDecimal valorTotal) {
        this.codigo = codigo;
        this.data = data;
        this.cliente = cliente;
        this.itens = itens;
        this.valorTotal = valorTotal;
    }
}
