package br.com.matheus.ibmprovatecnica.mapper.impl;

import br.com.matheus.ibmprovatecnica.domain.dto.CompraDTO;
import br.com.matheus.ibmprovatecnica.domain.entity.Compra;
import br.com.matheus.ibmprovatecnica.mapper.ComprasMapper;
import br.com.matheus.ibmprovatecnica.mapper.ProdutoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComprasMapperImpl implements ComprasMapper {

    @Autowired
    private ProdutoMapper produtoMapper;

    @Override
    public List<CompraDTO> comprasToDTO(List<Compra> compras) {
        List<CompraDTO> comprasDTO = new ArrayList<>();

        compras.forEach(compra -> comprasDTO.add(compraToDTO(compra)));

        return comprasDTO;
    }

    @Override
    public CompraDTO compraToDTO(Compra compra) {
        CompraDTO compraDTO = new CompraDTO();

        compraDTO.setCodigo(compra.getCodigo());
        compraDTO.setCliente(compra.getCliente());
        compraDTO.setData(compra.getData());
        compraDTO.setItens(produtoMapper.produtosToDTO(compra.getItens()));
        compraDTO.setValorTotal(compra.getValorTotal());

        return compraDTO;
    }
}
