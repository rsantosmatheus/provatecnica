package br.com.matheus.ibmprovatecnica.repository;

import br.com.matheus.ibmprovatecnica.domain.entity.Compra;

import java.util.List;
import java.util.Optional;

public interface ComprasRepository {

    List<Compra> findAllComprasOrdenada();

    Compra findMaiorCompraDoAno(Integer ano);

    List<Compra> findTresMaioresCompras();

    List<String> findCpfTresMaioresCompradores();
}
