package pe.edu.upc.serviceimpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.repository.ClienteRepository;
import pe.edu.upc.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private ClienteRepository cR;
	
	@Override
	@Transactional
	public Integer insertar(Cliente cliente) {
		int rpta = cR.buscarDniCliente(cliente.getDniCliente());
		if (rpta== 0) {		
			cR.save(cliente);

		}
		return rpta;

	}

	@Override
	@Transactional
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return cR.findAll(Sort.by(Sort.Direction.ASC,"idCliente"));
	}

	@Override
	@Transactional
	public List<Cliente> buscarDni(String dniCliente) {
		// TODO Auto-generated method stub
		return cR.findByDniCliente(dniCliente);
	}

	@Override
	@Transactional
	public List<Cliente> buscarNombre(String nombreCliente) {
		// TODO Auto-generated method stub
		return cR.findByNombreCliente(nombreCliente);
	}

	@Override
	@Transactional
	public List<Cliente> buscarApellido(String apellidoCliente) {
		// TODO Auto-generated method stub
		return cR.findByApellidoCliente(apellidoCliente);
	}

	@Override
	@Transactional
	public List<Cliente> buscarFecha(Date nacimientoCliente) {
		// TODO Auto-generated method stub
		return cR.findByNacimientoCliente(nacimientoCliente);
	}
	
	
}
