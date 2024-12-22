package br.com.ifsul.contador_presenca;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	
	
	@GetMapping("/oi")
	public String darOi() {
		return "Hello World!";
		
	}

}
