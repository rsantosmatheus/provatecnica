package br.com.matheus.ibmprovatecnica.repository.repositoryImpl;

import br.com.matheus.ibmprovatecnica.domain.entity.Cliente;
import br.com.matheus.ibmprovatecnica.repository.ClientesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
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
            return (List<Cliente>) mapper.readValue(jsonfie, List.class);

        } catch (IOException ex) {
            throw ex;
        }
    }
}
