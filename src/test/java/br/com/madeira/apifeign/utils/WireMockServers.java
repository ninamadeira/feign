package br.com.madeira.apifeign.utils;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import static br.com.madeira.apifeign.utils.Constants.ZIPCODE_OK;
import static br.com.madeira.apifeign.utils.Constants.ZIPCODE_NOK;

@Component
public class WireMockServers {

	public void serverZipCodeFound(Resource body) {
		WireMock.stubFor(WireMock
				.get(String.format("/address?zipcode=%s", ZIPCODE_OK))
				.willReturn(WireMock.aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "application/json")
						.withBody(ResourceUtils.getContentFile(body))));
	}

	public void serverInternalServerError(Resource body) {
		WireMock.stubFor(WireMock
				.get(String.format("/address?zipcode=%s", ZIPCODE_NOK))
				.willReturn(WireMock.aResponse()
						.withStatus(400)
						.withHeader("Content-Type", "application/json")
						.withBody(ResourceUtils.getContentFile(body))));
	}
}
