package com.examen_1.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examen_1.modelo.Medicamentos;
import com.examen_1.repositorio.IMedicamentosRepositorio;

@Controller
@RequestMapping("/medicamentos")
public class MedicamentosController {
	
	@Autowired
	private IMedicamentosRepositorio medicamentosRepositorio;
	
	@GetMapping("/")
	public String listarMedicamento(Model model) {
		List<Medicamentos> medicamento = medicamentosRepositorio.findAll();
		model.addAttribute("medicamentos", medicamento);
		return "listarMedicamento";
	}
	
	@GetMapping("/nuevo")
	public String nuevoMedicamento(Model model) {
		model.addAttribute("Medicamentos", new Medicamentos());
		return "nuevo";
	}
	
	@PostMapping("/guardar")
	public String guardarMedicamentos(@ModelAttribute Medicamentos medicamentos) {
		medicamentosRepositorio.save(medicamentos);
		return "redirect:/medicamentos/";
		}
}






