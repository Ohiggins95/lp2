package controlador;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import modelo.Categoria;
import com.example.simulacioncompras.repository.CategoriaRepository;


	@Controller
	@RequestMapping("/categorias")
	
	public class Categoriascontroller {
		@Autowired
		private CategoriaRepository categoRep;
		
		@GetMapping("/")
		public String listarcliente(Model model) {
			List<Categoria> categoria = categoRep.findAll();
			model.addAttribute("categoria", categoria);
			return "listarcompras"; 
		}

		@GetMapping("/nuevo")
		public String nuevacategoria(Model model) {
			model.addAttribute("compras", new Categoria());
			return "nuevo"; 
		}

		@PostMapping("/guardar")
		public String guardarproducto(@ModelAttribute Categoria compras) {
			categoRep.save(compras);
			return "redirect:/productos/"; 
		}

		@GetMapping("/editar/{id}")
		public String editarcompra(@PathVariable Integer id, Model model) {
			Categoria categoria = categoRep.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("ID de cliente no válido"));
			model.addAttribute("Categoria", categoria);
			return "editacompra";
		}

		@GetMapping("/eliminar/{id}")
		public String eliminarcompras(@PathVariable Integer id) {
			categoRep.deleteById(id);
			return "redirect:/productos/";
		}
	}


