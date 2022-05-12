package br.com.matheus.ibmprovatecnica.service.impl;

import br.com.matheus.ibmprovatecnica.domain.dto.ClienteDTO;
import br.com.matheus.ibmprovatecnica.domain.dto.CompraDTO;
import br.com.matheus.ibmprovatecnica.domain.entity.Cliente;
import br.com.matheus.ibmprovatecnica.domain.entity.Compra;
import br.com.matheus.ibmprovatecnica.mapper.ClienteMapper;
import br.com.matheus.ibmprovatecnica.mapper.ComprasMapper;
import br.com.matheus.ibmprovatecnica.repository.ClientesRepository;
import br.com.matheus.ibmprovatecnica.repository.ComprasRepository;
import br.com.matheus.ibmprovatecnica.service.IbmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return comprasMapper.comprasToDTO(comprasRepository.findAllComprasOrdenada());
    }

    @Override
    public List<ClienteDTO> getTresMaioresCompradores() {
        List<String> tresMaioresCompradoresCpf = comprasRepository.findCpfTresMaioresCompradores();
        List<Cliente> tresMaioresCompradores = clientesRepository.findClientesByCpfList(tresMaioresCompradoresCpf);

        return clienteMapper.clientesToDTO(tresMaioresCompradores);
    }
}
