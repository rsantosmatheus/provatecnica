package br.com.matheus.ibmprovatecnica.repository;

import br.com.matheus.ibmprovatecnica.domain.entity.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Paths;

@Repository
public class ClientesRepository {

    private static Cliente mappingJsonFileClientes(){

        Cliente cliente = new Cliente();

        try {
            ObjectMapper mapper = new ObjectMapper();
            cliente = mapper.readValue(Paths.get("clientes.json").toFile(), Cliente.class);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return cliente;
    }
}
