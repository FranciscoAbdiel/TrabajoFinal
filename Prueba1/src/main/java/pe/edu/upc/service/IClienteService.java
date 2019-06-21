package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Cliente;

public interface IClienteService {
	
	public void insertar(Cliente cliente);

	public void modificar(Cliente cliente);

	public void eliminar(int idCliente);

	Optional<Cliente> listarId(int idCliente);

	List<Cliente> listar();

}
