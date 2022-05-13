package br.com.matheus.ibmprovatecnica.repository.repositoryImpl;

import br.com.matheus.ibmprovatecnica.domain.entity.Compra;
import br.com.matheus.ibmprovatecnica.repository.ComprasRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
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

    @Override
    public Compra findMaiorCompraDoAno(Integer ano) {
        List<Compra> comprasAno = new ArrayList<>();

        compras.forEach(compra -> {
            LocalDate localDate = compra.getData().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (ano.equals(localDate.getYear())) {
                comprasAno.add(compra);
            }
        });

        List<Compra> comprasAnoOrdenada = comprasAno.stream().sorted(Comparator.comparing(Compra::getValorTotal).reversed()).collect(Collectors.toList());

        return comprasAnoOrdenada.stream().findFirst().orElseThrow();

    }

    @Override
    public List<Compra> findTresMaioresCompras() {
        return findAllComprasOrdenada().subList(0, 3);
    }

    @Override
    public List<String> findCpfTresMaioresCompradores() {
        List<String> tresMaioresCompradores = new ArrayList<>();

        findTresMaioresCompras().forEach(compra -> tresMaioresCompradores.add(compra.getCliente()));

        return tresMaioresCompradores;
    }
}
