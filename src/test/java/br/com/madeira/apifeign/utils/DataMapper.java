package br.com.madeira.apifeign.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class DataMapper {

	@Getter
	@Setter
	@Value("classpath:json/zipCode_OK.json")
	private Resource zipCodeOK;

	@Getter
	@Setter
	@Value("classpath:json/zipCode_NOK.json")
	private Resource zipCodeNOK;
}
