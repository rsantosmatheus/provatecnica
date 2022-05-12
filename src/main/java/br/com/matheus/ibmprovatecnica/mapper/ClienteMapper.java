package br.com.matheus.ibmprovatecnica.mapper;

import br.com.matheus.ibmprovatecnica.domain.dto.ClienteDTO;
import br.com.matheus.ibmprovatecnica.domain.entity.Cliente;

import java.util.List;

public interface ClienteMapper {

    List<ClienteDTO> clientesToDTO(List<Cliente> clientes);

    ClienteDTO clienteToDTO(Cliente cliente);
}
