package br.com.matheus.ibmprovatecnica.utils.impl;

import br.com.matheus.ibmprovatecnica.utils.TratamentoCPF;
import org.springframework.stereotype.Component;

@Component
public class TratamentoCPFImpl implements TratamentoCPF {

    @Override
    public String trataCPF(String cpf){
        return  cpf.substring(cpf.length()-11)
                .replaceAll("[^a-zA-Z0-9]", "");
    }
}