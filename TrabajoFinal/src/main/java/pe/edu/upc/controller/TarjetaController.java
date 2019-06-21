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

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.Tarjeta;
import pe.edu.upc.service.ITipotarjetaService;
import pe.edu.upc.service.ITarjetaService;

@Controller
@RequestMapping("/tarjetas")
public class TarjetaController {
	@Autowired
	private ITarjetaService tService;
	@Autowired
	private ITipotarjetaService ttService;

	@GetMapping("/bienvenido")
	public String bienvenido(Model model) {
		return "bienvenido";
	}

	@GetMapping("/nuevo")
	public String nuevoTarjeta(Model model) {
		model.addAttribute("tarjeta", new Tarjeta());
		model.addAttribute("listaTipotarjetas", ttService.listar());
		return "tarjeta/tarjeta";
	}

	@PostMapping("/guardar")
	public String guardarTarjeta(@ModelAttribute @Valid Tarjeta tarjeta, BindingResult result, Model model,
			SessionStatus status) throws Exception {
		if(result.hasErrors()){
			model.addAttribute("listaTipotarjetas", ttService.listar());
			return "/tarjeta/tarjeta";
		} else {
		
		int rpta = tService.insertar(tarjeta);
		if (rpta > 0) {
			model.addAttribute("mensaje", "Ya existe");
			model.addAttribute("listaTipotarjetas", ttService.listar());

			return "/tarjeta/tarjeta";
		} else {
			model.addAttribute("mensaje", "Se guardó correctamente");
			status.setComplete();
		}
		}
	model.addAttribute("listaTarjetas",tService.listar());

	return"/tarjeta/listaTarjeta";

	}

	@GetMapping("/listar")
	public String listarTarjetas(Model model) {
		try {
			model.addAttribute("tarjeta", new Tarjeta());

			model.addAttribute("listaTarjetas", tService.listar());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/tarjeta/listaTarjeta";
	}

	@GetMapping("/detalle/{id}")
	public String detailsTarjeta(@PathVariable(value = "id") int id, Model model) {
		try {
			Optional<Tarjeta> tarjeta = tService.listarId(id);

			if (!tarjeta.isPresent()) {
				model.addAttribute("info", "Tarjeta no existe");
				return "redirect:/tarjetas/listar";
			} else {
				model.addAttribute("tarjeta", tarjeta.get());

			}

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/tarjeta/tarjeta";
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				tService.eliminar(id);
				model.put("mensaje", "Se eliminÃ³ correctamente");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "No se puede eliminar un producto");
		}
		model.put("listaTarjetas", tService.listar());

		return "redirect:/tarjetas/listar";
	}

	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Tarjeta tarjeta) throws ParseException {

		List<Tarjeta> listaTarjetas;
		tarjeta.setNumeroTarjeta(tarjeta.getNumeroTarjeta());
		listaTarjetas = tService.buscar(tarjeta.getNumeroTarjeta());

		if (listaTarjetas.isEmpty()) {
			listaTarjetas = tService.buscarTipotarjeta(tarjeta.getNumeroTarjeta());
		}
		if (listaTarjetas.isEmpty()) {
			listaTarjetas = tService.buscarNumeroTarjeta(tarjeta.getNumeroTarjeta());
		}
		if (listaTarjetas.isEmpty()) {
			model.put("mensaje", "No se encontrÃ³");
		}
		model.put("listaTarjetas", listaTarjetas);
		return "tarjeta/listaTarjeta";

	}

	
	@GetMapping(value = "/ver/{id}")
	public String ver(@PathVariable(value = "id") Integer id, Map<String, Object> model, RedirectAttributes flash) {

		Optional<Tarjeta> tarjeta = tService.listarId(id);
		if (tarjeta == null) {
			flash.addFlashAttribute("error", "El Producto no existe en la base de datos");
			return "redirect:/tarjetas/listar";
		}

		model.put("tarjeta", tarjeta.get());

		return "tarjeta/ver";
	}
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Tarjeta> objTar = tService.listarId(id);

		if (objTar == null) {
			objRedir.addFlashAttribute("mensaje", "OcurriÃ³Â³ un error");
			return "redirect:/tarjetas/listar";
		} else {
			model.addAttribute("listaTipotarjetas", ttService.listar());

			model.addAttribute("tarjeta", objTar.get());
			return "tarjeta/tarjeta";
		}
	}

}
