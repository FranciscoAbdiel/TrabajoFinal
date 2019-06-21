package pe.edu.upc.controller;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entity.Tipotarjeta;
import pe.edu.upc.service.ITipotarjetaService;

@Controller
@RequestMapping("/tipotarjetas")
public class TipotarjetaController {

	@Autowired
	private ITipotarjetaService tService;

	@GetMapping("/nuevo")
	public String nuevoTipotarjeta(Model model) {
		model.addAttribute("tipotarjeta", new Tipotarjeta());
		return "tipotarjeta/tipotarjeta";
	}
	@PostMapping("/guardar")
	public String guardarTipotarjeta(@Valid Tipotarjeta tipotarjeta, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			return "tipotarjeta/tipotarjeta";
		} else {
			int rpta = tService.insertar(tipotarjeta);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				return "/tipotarjeta/tipotarjeta";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("listaTipotarjetas", tService.listar());

		return "/tipotarjeta/listaTipotarjeta";
	}
	
	@GetMapping("/listar")
	public String listarTipotarjetas(Model model) {
		try {
			model.addAttribute("tipotarjeta", new Tipotarjeta());
			model.addAttribute("listaTipotarjetas", tService.listar());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/tipotarjeta/listaTipotarjeta";
	}

	@GetMapping("/detalle/{id}")
	public String detailsTipotarjeta(@PathVariable(value = "id") int id, Model model) {
		try {
			Optional<Tipotarjeta> tipotarjeta = tService.listarId(id);
			if (!tipotarjeta.isPresent()) {
				model.addAttribute("info", "esta categoria no existe");
				return "redirect:/tipotarjetas/listar";
			} else {
				model.addAttribute("tipotarjeta", tipotarjeta.get());
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/tipotarjeta/tipotarjeta";
	}
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				tService.eliminar(id);
				model.put("mensaje", "Se eliminó correctamente");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "No se puede eliminar una categoria");
		}
		model.put("listaTipotarjetas", tService.listar());

		return "redirect:/tipotarjetas/listar";
	}

	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Tipotarjeta tipotarjeta) throws ParseException {
		List<Tipotarjeta> listaTipotarjetas;
		tipotarjeta.setNameTipotarjeta(tipotarjeta.getNameTipotarjeta());
		listaTipotarjetas = tService.buscarNombre(tipotarjeta.getNameTipotarjeta());

		if (listaTipotarjetas.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaTipotarjetas", listaTipotarjetas);
		return "tipotarjeta/listaTipotarjeta";

	}
}

