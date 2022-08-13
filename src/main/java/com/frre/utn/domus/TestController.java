package com.frre.utn.domus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping(value="/test")
	public String test(){
		return "Hola Mundo";
		
	}

}
