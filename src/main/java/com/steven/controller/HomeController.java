package com.steven.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.steven.model.Vacante;
import com.steven.service.IVacantesService;

@Controller
public class HomeController {
	
	@Autowired
	private IVacantesService serviceVacante;
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> Lista = serviceVacante.buscarTodas();
		model.addAttribute("vacantes", Lista);
		
		return "tabla";
	}
		
	@GetMapping("/detalle")
	public String mostrarDetalles(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de Comunicaciones");
		vacante.setDescripcion("Se necesita ingeniero para dar soporte a intranet");
		vacante.setFecha(new Date());
		vacante.setSalario(1200.000);

		model.addAttribute("vacante", vacante);
		return "detalle";
	}

	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero de Sistemas");
		lista.add("Auxiliar Contable");
		lista.add("Vendedor");
		lista.add("Arquitecto");

		model.addAttribute("empleos", lista);
		return "listado";
	}

	@GetMapping("/")
	public String mostratHome(Model model) {
		List<Vacante> Lista = serviceVacante.buscarTodas();
		model.addAttribute("vacantes", Lista);

		return "home";
	}

	

}
