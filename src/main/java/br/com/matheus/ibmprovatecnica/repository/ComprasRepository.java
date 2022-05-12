package br.com.matheus.ibmprovatecnica.repository;

import br.com.matheus.ibmprovatecnica.domain.entity.Compra;

import java.util.List;

public interface ComprasRepository {

    List<Compra> findAllComprasOrdenada();
}
