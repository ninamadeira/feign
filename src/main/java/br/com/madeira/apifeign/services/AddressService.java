package br.com.madeira.apifeign.services;


import br.com.madeira.apifeign.client.AddressClient;
import br.com.madeira.apifeign.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressService {

    private final AddressClient addressClient;

    public Address execute(String zipcode) {

        return addressClient.findAddressByZipCode(zipcode);
    }
}
