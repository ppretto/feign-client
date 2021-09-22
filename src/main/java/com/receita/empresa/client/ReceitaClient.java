package com.receita.empresa.client;

import com.receita.empresa.response.ReceitaEmpresaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "simple-client", url="${receita.service.url}")
public interface ReceitaClient {

    @GetMapping("/{cnpj}")
    ReceitaEmpresaResponse getEmpresa(@PathVariable String cnpj);


}
