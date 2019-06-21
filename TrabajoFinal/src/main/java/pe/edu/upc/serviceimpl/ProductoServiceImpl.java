package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Producto;
import pe.edu.upc.repository.ProductoRepository;
import pe.edu.upc.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private ProductoRepository pR;

	@Override
	@Transactional
	public Integer insertar(Producto producto) {

		int rpta = pR.buscarNombreProducto(producto.getNombreProducto());
		if (rpta == 0) {
			pR.save(producto);
		}

		return rpta;

	}

	

	@Override
	@Transactional
	public void modificar(Producto producto) {
		// TODO Auto-generated method stub
		pR.save(producto);
	}

	@Override
	@Transactional
	public void eliminar(int idProducto) {
		// TODO Auto-generated method stub
		pR.deleteById(idProducto);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> listarId(int idProducto) {
		// TODO Auto-generated method stub
		return pR.findById(idProducto);
	}

	@Override
	@Transactional
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return pR.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> buscar(String nombreProducto) {
		// TODO Auto-generated method stub
		return pR.findByNombreProducto(nombreProducto);
	}

	@Override
	public List<Producto> buscarCategoria(String nombreCategoria) {
		// TODO Auto-generated method stub
		return pR.buscarCategoria(nombreCategoria);
	}

	@Override
	public List<Producto> findByNombreProductoLikeIgnoreCase(String nombreProducto) {
		// TODO Auto-generated method stub
		return pR.findByNombreProductoLikeIgnoreCase(nombreProducto);
	}

}
