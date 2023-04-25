package com.bolsadeideas.springboot.horarioInterceptor.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PropertySource(value={"classpath:application.properties"})
public class AppController {

	
	@Value("${config.horario.apertura}")
	private Integer apertura;
	
	@Value("${config.horario.cierre}")
	private Integer cierre;
	
	@GetMapping({"/", "/index"})
	public String index(Model model) {
		model.addAttribute("titulo","bienvenido al horario");
		return "/index";
	}
	
	@GetMapping("/cerrado")
	public String cerrado(Model model) {
		
		StringBuilder mensaje = new StringBuilder("Cerrado, por favor visitenos desde las ");
		mensaje.append(apertura);
		mensaje.append("hrs. ");
		mensaje.append("y las ");
		mensaje.append(cierre);
		mensaje.append("hrs. Gracias");
		
		model.addAttribute("titulo","fuera del horario de atencion");
		model.addAttribute("mensaje", mensaje);
		return "/cerrado";
	}
}
