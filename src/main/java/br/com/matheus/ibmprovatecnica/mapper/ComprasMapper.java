package br.com.matheus.ibmprovatecnica.mapper;

import br.com.matheus.ibmprovatecnica.domain.dto.CompraDTO;
import br.com.matheus.ibmprovatecnica.domain.entity.Compra;

import java.util.List;
import java.util.Optional;

public interface ComprasMapper {

    List<CompraDTO> comprasToDTO(List<Compra> compras);

    CompraDTO compraToDTO(Compra compra);

}
