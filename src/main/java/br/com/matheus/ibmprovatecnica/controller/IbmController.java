package br.com.matheus.ibmprovatecnica.controller;


import br.com.matheus.ibmprovatecnica.domain.dto.CompraDTO;
import br.com.matheus.ibmprovatecnica.service.IbmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class IbmController {

    @Autowired
    private IbmService ibmService;

    @GetMapping("/compras")
    public List<CompraDTO> getListaDeComprasOrdemDecrescente() {
        return ibmService.getListaDeComprasOrdemDecrescente();
    }
}