package br.com.matheus.ibmprovatecnica.mapper.impl;

import br.com.matheus.ibmprovatecnica.domain.dto.ProdutoDTO;
import br.com.matheus.ibmprovatecnica.domain.entity.Produto;
import br.com.matheus.ibmprovatecnica.mapper.ProdutoMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoMapperImpl implements ProdutoMapper {

    @Override
    public List<ProdutoDTO> produtosToDTO(List<Produto> produtos) {
        List<ProdutoDTO> produtosDTO = new ArrayList<>();

        produtos.forEach(produto -> produtosDTO.add(produtoToDTO(produto)));

        return produtosDTO;
    }

    @Override
    public ProdutoDTO produtoToDTO(Produto produto) {
        ProdutoDTO produtoDTO = new ProdutoDTO();

        produtoDTO.setProduto(produto.getProduto());
        produtoDTO.setCategoria(produto.getCategoria());
        produtoDTO.setPais(produto.getPais());
        produtoDTO.setPreco(produto.getPreco());
        produtoDTO.setSafra(produto.getSafra());
        produtoDTO.setVariedade(produto.getVariedade());

        return produtoDTO;
    }
}
