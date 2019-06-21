package pe.edu.upc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.service.IClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteService cService;
	@RequestMapping("/bienvenido")
	public String irBienvenido() {
		return "bienvenido";
	}
	@GetMapping("/nuevo")
	public String nuevoCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "cliente/cliente";
	}
	
	@PostMapping("/guardar")
	public String guardarCliente(@Valid Cliente cliente,BindingResult result,Model model,SessionStatus status)
	              throws Exception{
		if(result.hasErrors()){
			return "/cliente/cliente";
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
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Cliente cliente) throws ParseException {

		List<Cliente> listaClientes;

		cliente.setNombreCliente(cliente.getNombreCliente());
		listaClientes = cService.buscarNombre(cliente.getNombreCliente());

		if (listaClientes.isEmpty()) {
			listaClientes = cService.buscarApellido(cliente.getNombreCliente());
		}
		if (listaClientes.isEmpty()) {
			listaClientes = cService.buscarDni(cliente.getNombreCliente());
		}
	
		if (listaClientes.isEmpty()) {
			try {

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				cliente.setNacimientoCliente(sdf.parse(cliente.getNombreCliente()));
				listaClientes = cService.buscarFecha(cliente.getNacimientoCliente());
			} catch (Exception e) {
				model.put("mensaje", "Formato incorreco");

			}
		}
		if (listaClientes.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaClientes", listaClientes);
		return "cliente/listaCliente";

	}

}
