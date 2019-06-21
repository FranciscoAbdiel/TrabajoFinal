package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Tipotarjeta;

public interface ITipotarjetaService {

	public Integer insertar(Tipotarjeta tipotarjeta);

	public void modificar(Tipotarjeta tipotarjeta);

	public void eliminar(int idTipotarjeta);

	Optional<Tipotarjeta> listarId(int idTipotarjeta);

	List<Tipotarjeta> listar();

	List<Tipotarjeta> buscarNombre(String nameTipoTarjeta);


}















