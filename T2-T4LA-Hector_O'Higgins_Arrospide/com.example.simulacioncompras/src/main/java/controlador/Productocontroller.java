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

import modelo.Producto;
import com.example.simulacioncompras.repository.ProductoRepository;


public class Productocontroller {

	@Controller
	@RequestMapping("/productos")
	public class ClienteController {
		@Autowired
		private ProductoRepository productosRep;
		
		@GetMapping("/")
		public String listarproductos(Model model) {
			List<Producto> productos = productosRep.findAll();
			model.addAttribute("productos", productos);
			return "listarproductos"; 
		}

		@GetMapping("/nuevo")
		public String nuevoproducto(Model model) {
			model.addAttribute("productos", new Producto());
			return "nuevo"; // nombre de la vista
		}

		@PostMapping("/guardar")
		public String guardarcompras(@ModelAttribute Producto productos) {
			productosRep.save(productos);
			return "redirect:/productos/"; 
		}

		@GetMapping("/editar/{id}")
		public String editarproductos(@PathVariable Long id, Model model) {
			Producto productos= productosRep.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("ID de cliente no válido"));
			model.addAttribute("productos", productos);
			return "editaproductos"; // Vista de edición
		}

		@GetMapping("/eliminar/{id}")
		public String eliminarproductos(@PathVariable Long id) {
			productosRep.deleteById(id);
			return "redirect:/compras/";
		}
	}
}
