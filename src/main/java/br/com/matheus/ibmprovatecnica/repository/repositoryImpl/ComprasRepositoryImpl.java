package br.com.matheus.ibmprovatecnica.repository.repositoryImpl;

import br.com.matheus.ibmprovatecnica.domain.entity.Compra;
import br.com.matheus.ibmprovatecnica.repository.ComprasRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ComprasRepositoryImpl implements ComprasRepository {

    private static List<Compra> compras;

    public ComprasRepositoryImpl() throws IOException {
        compras = mappingJsonFileCompras();
    }

    private List<Compra> mappingJsonFileCompras() throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File jsonfie = new ClassPathResource("compras.json").getFile();

            return mapper.readValue(jsonfie, new TypeReference<List<Compra>>() {
            });

        } catch (IOException ex) {
            throw ex;
        }
    }

    @Override
    public List<Compra> findAllComprasOrdenada() {
        return compras.stream().sorted(Comparator.comparing(Compra::getValorTotal)
                .reversed()).collect(Collectors.toList());
    }
}
