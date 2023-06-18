package Grupo5.TBD.Laboratorio1.Services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Services {

	@GetMapping("/hello")
	public String HelloWorld(){
    	return "Hello World";
	}
}
