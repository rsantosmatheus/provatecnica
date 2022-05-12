package br.com.matheus.ibmprovatecnica.repository.repositoryImpl;

import br.com.matheus.ibmprovatecnica.domain.entity.Cliente;
import br.com.matheus.ibmprovatecnica.repository.ClientesRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClientesRepositoryImpl implements ClientesRepository {

    private static List<Cliente> clientes;

    public ClientesRepositoryImpl() throws IOException {
        clientes = mappingJsonFileClientes();
    }

    private List<Cliente> mappingJsonFileClientes() throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();

            File jsonfie = new ClassPathResource("clientes.json").getFile();
            return mapper.readValue(jsonfie, new TypeReference<List<Cliente>>() {});

        } catch (IOException ex) {
            throw ex;
        }
    }

    /*Nos arquivos os campos referentes ao cpf do cliente estavam diferentes tanto na quantidade de zeros
    * quanto nos caracteres especiais. Para isso, adicionei alguns tratamentos, removendo caracteres especiais
    * e considerando apenas os ultimos 11 caracteres da String*/
    @Override
    public Cliente findClienteByCpf(String cpf){
        return clientes.stream().filter(cliente ->
                cpf.substring(cpf.length()-11)
                        .replaceAll("[^a-zA-Z0-9]", "")
                        .equals(cliente.getCpf().substring(cliente.getCpf().length()-11)
                                .replaceAll("[^a-zA-Z0-9]", "")))
                .findAny().orElse(null);
    }

    @Override
    public List<Cliente> findClientesByCpfList (List<String> clientesCPF){
        List<Cliente> clientes = new ArrayList<>();

        clientesCPF.forEach(cpfCliente -> clientes.add(findClienteByCpf(cpfCliente)));

        return clientes;
    }
}
