package br.com.matheus.ibmprovatecnica.mapper.impl;

import br.com.matheus.ibmprovatecnica.domain.dto.ClienteDTO;
import br.com.matheus.ibmprovatecnica.domain.entity.Cliente;
import br.com.matheus.ibmprovatecnica.mapper.ClienteMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public List<ClienteDTO> clientesToDTO(List<Cliente> clientes) {
        List<ClienteDTO> clientesDTO = new ArrayList<>();

        clientes.forEach(cliente -> clientesDTO.add(clienteToDTO(cliente)));

        return clientesDTO;
    }

    @Override
    public ClienteDTO clienteToDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setCpf(cliente.getCpf());
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNome(cliente.getNome());

        return clienteDTO;
    }
}
