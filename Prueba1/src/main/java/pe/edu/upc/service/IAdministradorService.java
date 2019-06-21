package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Administrador;

public interface IAdministradorService {
	
	public void insertar(Administrador administrador);

	public void modificar(Administrador administrador);

	public void eliminar(int idAdministrador);

	Optional<Administrador> listarId(int idAdministrador);

	List<Administrador> listar();

}
