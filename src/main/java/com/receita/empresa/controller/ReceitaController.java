package com.receita.empresa.controller;

import com.receita.empresa.response.ReceitaEmpresaResponse;
import com.receita.empresa.client.ReceitaClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log
public class ReceitaController {


    private final ReceitaClient client;

    @GetMapping("/cnpj/{cnpj}")
    public ReceitaEmpresaResponse getEmpresa(@PathVariable String cnpj) {
        log.info("Iniciando método getEmpresa. Pesquisando por CNPJ: " + cnpj);
        return client.getEmpresa(cnpj);
    }
}
