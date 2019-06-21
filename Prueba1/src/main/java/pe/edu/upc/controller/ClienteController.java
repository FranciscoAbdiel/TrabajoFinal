package pe.edu.upc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.repository.UserRepository;
import pe.edu.upc.service.IClienteService;
import pe.edu.upc.serviceimpl.JpaUserDetailsService;

@Controller
@SessionAttributes("cliente")
@RequestMapping("/clientes")
public class ClienteController {


	@Autowired
	private IClienteService cService;
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/bienvenido")
	public String irBienvenido() {
		return "bienvenido";
	}

	//@Secured("ROLE_ADMIN")
	@GetMapping("/nuevo")
	public String nuevoCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "pruebas";
	}

	@PostMapping("/guardar")
	public String guardarCliente(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		/*if (result.hasErrors()) {
			return "cliente/cliente";
		} else {
			int rpta = cService.insertar(cliente);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				return  "/cliente/cliente";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("listaClientes", cService.listar());
		return "/cliente/listaCliente";
*/
		if (result.hasErrors()) {
			return "/cliente/cliente";
		} else {
	
			cService.insertar(cliente);
			model.addAttribute("mensaje", "Se guardó correctamente");
			status.setComplete();
			return "redirect:/clientes/listar";
		}
	}

	@GetMapping("/listar")
	public String listarClientes(Model model) {
		try {
			model.addAttribute("cliente", new Cliente());
			model.addAttribute("listaClientes", cService.listar());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/cliente/listaCliente";
	}
	
}
