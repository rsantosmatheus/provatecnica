package br.com.matheus.ibmprovatecnica.service.impl;

import br.com.matheus.ibmprovatecnica.domain.dto.ClienteDTO;
import br.com.matheus.ibmprovatecnica.domain.dto.CompraDTO;
import br.com.matheus.ibmprovatecnica.domain.entity.Cliente;
import br.com.matheus.ibmprovatecnica.domain.entity.Compra;
import br.com.matheus.ibmprovatecnica.domain.entity.Produto;
import br.com.matheus.ibmprovatecnica.mapper.ClienteMapper;
import br.com.matheus.ibmprovatecnica.mapper.ComprasMapper;
import br.com.matheus.ibmprovatecnica.repository.ClientesRepository;
import br.com.matheus.ibmprovatecnica.repository.ComprasRepository;
import br.com.matheus.ibmprovatecnica.service.IbmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class IbmServiceImpl implements IbmService {

    @Autowired
    private ComprasRepository comprasRepository;

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private ComprasMapper comprasMapper;

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public List<CompraDTO> getListaDeComprasOrdemDecrescente() {
        List<Compra> comprasOrdenadas = comprasRepository.findAllComprasOrdenada();

        return comprasMapper.comprasToDTO(comprasOrdenadas);
    }

    @Override
    public CompraDTO getMaiorCompraDoAno(Integer ano) {
        Compra maiorCompraDoAno = comprasRepository.findMaiorCompraDoAno(ano);

        return comprasMapper.compraToDTO(maiorCompraDoAno);
    }

    @Override
    public List<ClienteDTO> getTresMaioresCompradores() {
        List<String> tresMaioresCompradoresCpf = comprasRepository.findCpfTresMaioresCompradores();
        List<Cliente> tresMaioresCompradores = clientesRepository.findClientesByCpfList(tresMaioresCompradoresCpf);

        return clienteMapper.clientesToDTO(tresMaioresCompradores);
    }

    @Override
    public String getRecomendacaoPorTipoECliente(String cliente, String tipo) {
        Compra compra = comprasRepository.findCompraByCliente(cliente);
        List<Produto> itens = comprasRepository.findProdutosByCompra(compra);
        List<Produto> itensFiltrados = itens.stream().filter(item -> item.getCategoria().equals(tipo)).collect(Collectors.toList());
        List<String> produto = new ArrayList<>();

        itensFiltrados.forEach(item -> produto.add(item.getProduto()));

        String maisComum = produto.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

        if (produto.size() == 0) {
            return "Recomendação não encontrada";
        } else {
            return maisComum;
        }
    }

}
