package pe.edu.upc.service;
import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Tarjeta;

public interface ITarjetaService {
	
	public Integer insertar(Tarjeta tarjeta);

	public void modificar(Tarjeta tarjeta);

	public void eliminar(int idTarjeta);

	Optional<Tarjeta> listarId(int idTarjeta);

	List<Tarjeta> listar();

	List<Tarjeta> buscar(String numeroTarjeta);

	List<Tarjeta> buscarTipotarjeta(String nameTipotarjeta);

	List<Tarjeta> buscarNumeroTarjeta(String numeroTarjeta);

}
