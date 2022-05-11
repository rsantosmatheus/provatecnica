package br.com.matheus.ibmprovatecnica.repository;

import br.com.matheus.ibmprovatecnica.domain.entity.Compra;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Paths;

@Repository
public class CompraRepository {

    private static Compra mappingJsonFileCompra(){

        Compra compra = new Compra();

        try {
            ObjectMapper mapper = new ObjectMapper();
            compra = mapper.readValue(Paths.get("compras.json").toFile(), Compra.class);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return compra;
    }
}
