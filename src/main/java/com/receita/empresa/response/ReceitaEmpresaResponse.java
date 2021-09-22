package com.receita.empresa.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Builder
public class ReceitaEmpresaResponse {


    private final List<AtividadePrincipal> atividade_principal;
    private final String data_situacao;
    private final String complemento;
    private final String tipo;
    private final String nome;
    private final String uf;
    private final String telefone;
    private final String email;
    private final List<AtividadesSecundaria> atividades_secundarias;
    private final List<Qsa> qsa;
    private final String situacao;
    private final String bairro;
    private final String logradouro;
    private final String numero;
    private final String cep;
    private final String municipio;
    private final String porte;
    private final String abertura;
    private final String natureza_juridica;
    private final String cnpj;
    private final Date ultima_atualizacao;
    private final String status;
    private final String fantasia;
    private final String efr;
    private final String motivo_situacao;
    private final String situacao_especial;
    private final String data_situacao_especial;
    private final String capital_social;
    private final Extra extra;
    private final Billing billing;

    @Getter
    @Builder
    public static class AtividadePrincipal{
        private String text;
        private String code;
    }

    @Getter
    @Builder
    public static class AtividadesSecundaria{
        private String text;
        private String code;
    }

    @Getter
    @Builder
    public static class Qsa{
        private String qual;
        private String pais_origem;
        private String nome_rep_legal;
        private String qual_rep_legal;
        private String nome;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(value = { "valorExtra" })
    public static class Extra{
        private Object valorExtra;
    }

    @Getter
    @Builder
    public static class Billing{
        private boolean free;
        private boolean database;
    }

}


