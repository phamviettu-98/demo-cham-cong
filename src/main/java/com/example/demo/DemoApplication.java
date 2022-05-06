package com.example.demo;

import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;
import kong.unirest.apache.ApacheClient;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner  {
	public static void main(String[] args) {
		Unirest.config().reset();
	   	Unirest.config().httpClient(ApacheClient.builder(UnsafeHttpClientUtil.getClient()));
//		Unirest.config().proxy("localhost", 9888);
		Unirest.config().concurrency(1000, 100);
		Unirest.config().connectTimeout(10000);
//		Unirest.config().followRedirects(false);
		Unirest.config().setObjectMapper(new ObjectMapper() {
			com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
 
			public String writeValue(Object value) {
				try {
					return mapper.writeValueAsString(value);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
				return null;
			}

			public <T> T readValue(String value, Class<T> valueType) {
				try {
					return mapper.readValue(value, valueType);
				} catch (JsonParseException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}
		});
		Unirest.config().verifySsl(false);
		
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}

}
