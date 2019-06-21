package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.repository.ClienteRepository;
import pe.edu.upc.service.IClienteService;

@Service
public class IClienteServiceImpl implements IClienteService{

	@Autowired
	private ClienteRepository cR;
	
	@Transactional
	@Override
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		cR.save(cliente);
	}

	@Transactional
	@Override
	public void modificar(Cliente cliente) {
		// TODO Auto-generated method stub
		cR.save(cliente);
	}

	@Transactional
	@Override
	public void eliminar(int idCliente) {
		// TODO Auto-generated method stub
		cR.deleteById(idCliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> listarId(int idCliente) {
		// TODO Auto-generated method stub
		return cR.findById(idCliente);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return cR.findAll(Sort.by(Sort.Direction.DESC, "datosCliente"));
	}

}
