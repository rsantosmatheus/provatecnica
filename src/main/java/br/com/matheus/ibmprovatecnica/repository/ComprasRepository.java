package br.com.matheus.ibmprovatecnica.repository;

import br.com.matheus.ibmprovatecnica.domain.entity.Compra;
import br.com.matheus.ibmprovatecnica.domain.entity.Produto;

import java.util.List;

public interface ComprasRepository {

    List<Compra> findAllComprasOrdenada();

    Compra findMaiorCompraDoAno(Integer ano);

    List<Compra> findTresMaioresCompras();

    List<String> findCpfTresMaioresCompradores();

    Compra findCompraByCliente(String cliente);

    List<Produto> findProdutosByCompra(Compra compra);
}
