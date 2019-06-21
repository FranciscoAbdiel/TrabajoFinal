package pe.edu.upc.service;

import java.util.Date;
import java.util.List;

import pe.edu.upc.entity.Cliente;

public interface IClienteService {

	
	public Integer insertar(Cliente cliente);
   
	List<Cliente> listar();
	List<Cliente> buscarDni(String dniCliente);
	List<Cliente> buscarNombre(String nombreCliente);
	List<Cliente> buscarApellido(String apellidoCliente);
	List<Cliente> buscarFecha(Date nacimientoCliente);

}
