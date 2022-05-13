package br.com.matheus.ibmprovatecnica.service;

import br.com.matheus.ibmprovatecnica.domain.dto.ClienteDTO;
import br.com.matheus.ibmprovatecnica.domain.dto.CompraDTO;

import java.util.List;

public interface IbmService {

    List<CompraDTO> getListaDeComprasOrdemDecrescente();

    CompraDTO getMaiorCompraDoAno(Integer ano);

    List<ClienteDTO> getTresMaioresCompradores();

    String getRecomendacaoPorTipoECliente(String cliente, String tipo);
}
