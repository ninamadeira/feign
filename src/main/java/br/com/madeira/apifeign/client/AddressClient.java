package br.com.madeira.apifeign.client;

import br.com.madeira.apifeign.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
public interface AddressClient {

    @GetMapping("{cep}/json")
    Address findAddressByZipCode(@PathVariable("cep") String cep);
}