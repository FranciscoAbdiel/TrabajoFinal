package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Categoria;
import pe.edu.upc.repository.CategoriaRepository;
import pe.edu.upc.service.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

	@Autowired
	private CategoriaRepository caR;

	@Override
	@Transactional
	public Integer insertar(Categoria categoria) {
		int rpta = caR.buscarNombreCategoria(categoria.getNombreCategoria());
		if (rpta== 0) {		
			caR.save(categoria);

		}
		return rpta;

	}

	@Override
	@Transactional
	public void modificar(Categoria categoria) {
		// TODO Auto-generated method stub
		caR.save(categoria);
	}

	@Override
	@Transactional
	public void eliminar(int idCategoria) {
		// TODO Auto-generated method stub
		caR.deleteById(idCategoria);
	}

	@Override
	@Transactional
	public Optional<Categoria> listarId(int idCategoria) {
		// TODO Auto-generated method stub
		return caR.findById(idCategoria);
	}

	@Override
	@Transactional
	public List<Categoria> listar() {
		// TODO Auto-generated method stub
		return caR.findAll(Sort.by(Sort.Direction.ASC,"nombreCategoria"));
	}

	@Override
	@Transactional
	public List<Categoria> buscarNombre(String nombreCategoria) {
		// TODO Auto-generated method stub
		return caR.findByNombreCategoria(nombreCategoria);
	}
}
