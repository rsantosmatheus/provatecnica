package br.com.matheus.ibmprovatecnica.repository;

import br.com.matheus.ibmprovatecnica.domain.entity.Cliente;

import java.util.List;

public interface ClientesRepository {

    Cliente findClienteByCpf(String cpf);

    List<Cliente> findClientesByCpfList(List<String> clientesCPF);
}
