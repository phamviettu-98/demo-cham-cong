package com.example.demo.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1.0")
public class HelloController {
	

	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> hello() {
		return  ResponseEntity.ok("Hello");
		
	}

}
