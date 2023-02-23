package br.com.madeira.apifeign.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Address {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
