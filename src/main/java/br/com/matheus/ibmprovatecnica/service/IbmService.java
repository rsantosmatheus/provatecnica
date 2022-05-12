package br.com.matheus.ibmprovatecnica.service;

import br.com.matheus.ibmprovatecnica.domain.dto.CompraDTO;

import java.util.List;

public interface IbmService {

    public List<CompraDTO> getListaDeComprasOrdemDecrescente();
}
