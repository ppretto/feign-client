package com.receita.empresa.services;

import com.receita.empresa.client.ReceitaClient;
import com.receita.empresa.response.ReceitaEmpresaResponse;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

@Log
public class ReceitaClientService {

    @Autowired
    private ReceitaClient receitaClient;

    public ReceitaClientService(ReceitaClient receitaClient) {
        this.receitaClient = receitaClient;
    }

    public ReceitaEmpresaResponse getEmpresa(@PathVariable String cnpj){
        log.info("Iniciando método getEmpresa. CNPJ: " + cnpj);
        return receitaClient.getEmpresa(cnpj);
    }

}
