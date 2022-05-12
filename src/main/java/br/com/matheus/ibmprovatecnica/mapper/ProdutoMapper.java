package br.com.matheus.ibmprovatecnica.mapper;

import br.com.matheus.ibmprovatecnica.domain.dto.CompraDTO;
import br.com.matheus.ibmprovatecnica.domain.dto.ProdutoDTO;
import br.com.matheus.ibmprovatecnica.domain.entity.Produto;

import java.util.List;

public interface ProdutoMapper {

    List<ProdutoDTO> produtosToDTO(List<Produto> produtos);

    ProdutoDTO produtoToDTO(Produto produto);
}
