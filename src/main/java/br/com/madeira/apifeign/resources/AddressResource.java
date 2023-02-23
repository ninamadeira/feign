package br.com.madeira.apifeign.resources;

import br.com.madeira.apifeign.model.Address;
import br.com.madeira.apifeign.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/address")
@RestController
public class AddressResource {

    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<Address> findAddress(@RequestParam(name = "zipcode") String zipcode) {
        return ResponseEntity.ok(addressService.execute(zipcode));

    }
}