package pe.edu.upc.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>{

	@Query("from Cliente c where c.dniCliente like %:dniCliente%")
	List<Cliente> findByDniCliente(String dniCliente);
	
	@Query("from Cliente c where c.nombreCliente like %:nombreCliente%")
	List<Cliente> findByNombreCliente(String nombreCliente);
	
	
	@Query("from Cliente c where c.apellidoCliente like %:apellidoCliente%")
	List<Cliente> findByApellidoCliente(String apellidoCliente);
	
	List<Cliente> findByNacimientoCliente(Date nacimientoCliente);

	@Query("select count(c.dniCliente) from Cliente c where c.dniCliente =:dniCliente")
	public int buscarDniCliente (@Param("dniCliente")String dniCliente);
}
