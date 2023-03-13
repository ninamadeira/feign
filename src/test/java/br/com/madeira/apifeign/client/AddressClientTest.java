package br.com.madeira.apifeign.client;

import br.com.madeira.apifeign.ApifeignApplication;
import br.com.madeira.apifeign.model.Address;
import br.com.madeira.apifeign.utils.DataMapper;
import br.com.madeira.apifeign.utils.WireMockServers;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import feign.FeignException.BadRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static br.com.madeira.apifeign.utils.Constants.ZIPCODE_NOK;
import static br.com.madeira.apifeign.utils.Constants.ZIPCODE_OK;
import static org.junit.jupiter.api.Assertions.*;

@WireMockTest(httpPort = 8100)
@SpringBootTest(classes = ApifeignApplication.class)
@TestPropertySource(locations = "classpath:application-ClientTest.properties")
public class AddressClientTest {
    @Autowired
    private AddressClient client;

    @Autowired
    private DataMapper dataMapper;

    @Autowired
    private WireMockServers wireMock;

    @Test
    @DisplayName("1 - Obtendo endereço através do cep")
    public void testGetAddress_200() {
        wireMock.serverZipCodeFound(dataMapper.getZipCodeOK());
        Address address = client.findAddressByZipCode(ZIPCODE_OK);
        assertNotNull(address);
    }

    @Test
    @DisplayName("2 - Erro server")
    public void testGetAddress_500() {
        wireMock.serverInternalServerError(dataMapper.getZipCodeNOK());
        assertThrows( BadRequest.class, () -> {
            client.findAddressByZipCode(ZIPCODE_NOK);
        });
    }
  
}