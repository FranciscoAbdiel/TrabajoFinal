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

import pe.edu.upc.entity.Categoria;
import pe.edu.upc.service.ICategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private ICategoriaService caService;
	@RequestMapping("/bienvenido")
	public String irBienvenido() {
		return "bienvenido";
	}
	@GetMapping("/nueva")
	public String nuevaCategoria(Model model)
	{
		model.addAttribute("categoria",new Categoria());
		return "categoria/categoria";
	}
	@PostMapping("/guardar")
	public String guardarCategoria(@Valid Categoria categoria,BindingResult result,Model model,SessionStatus status)
		throws Exception{
			if(result.hasErrors()) {
				return "/categoria/categoria";
			}else {
				int rpta = caService.insertar(categoria);
				if (rpta > 0) {
					model.addAttribute("mensaje", "Ya existe");
					return  "/categoria/categoria";
				} else {
					model.addAttribute("mensaje", "Se guardó correctamente");
					status.setComplete();
			}
			model.addAttribute("listaCategorias", caService.listar());

			return "/categoria/listaCategoria";
		}
			}

	@GetMapping("/listar")
	public String listarCategorias(Model model) {
		try {
			model.addAttribute("categoria",new Categoria());
			model.addAttribute("listaCategorias",caService.listar());
		} catch(Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "/categoria/listaCategoria";
	}
	@GetMapping("/detalle/{id}")
	public String detailsCategoria(@PathVariable(value="id") int id,Model model) {
		try {
			Optional<Categoria> categoria= caService.listarId(id);
			if(!categoria.isPresent()) {
				model.addAttribute("info","Categoria no existe");
				return "redirect:/categorias/listar";
			}else {
				model.addAttribute("categoria",categoria.get());
			}
		}
		catch(Exception e){
			model.addAttribute("error",e.getMessage());
		}
		return "/categoria/categoria";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String,Object> model,@RequestParam(value="id") Integer id) {
		try {
			if(id !=null && id>0) {
				caService.eliminar(id);
				model.put("mensaje","Se eliminó correctamente");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje","No se puede eliminar una categoria");
			
		}
		model.put("listaCategorias",caService.listar());
		return "redirect:/categorias/listar";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String,Object> model,@ModelAttribute Categoria categoria) throws ParseException{
		
		List<Categoria> listaCategorias;
		
		categoria.setNombreCategoria(categoria.getNombreCategoria());
		listaCategorias=caService.buscarNombre(categoria.getNombreCategoria());
		
		if(listaCategorias.isEmpty()) {
			model.put("mensaje","No sé encontró");
		}
		model.put("listaCategorias", listaCategorias);
		return "categoria/listaCategoria";
	}
	
}
