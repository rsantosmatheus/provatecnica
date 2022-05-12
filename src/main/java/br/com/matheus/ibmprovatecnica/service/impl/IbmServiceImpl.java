package br.com.matheus.ibmprovatecnica.service.impl;

import br.com.matheus.ibmprovatecnica.domain.dto.CompraDTO;
import br.com.matheus.ibmprovatecnica.mapper.ComprasMapper;
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
    private ComprasMapper comprasMapper;

    @Override
    public List<CompraDTO> getListaDeComprasOrdemDecrescente() {
        return comprasMapper.comprasToDTO(comprasRepository.findAllComprasOrdenada());
    }
}
