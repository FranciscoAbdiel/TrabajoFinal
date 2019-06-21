package pe.edu.upc.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Tarjeta;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer> {
	@Query("select t from Tarjeta t where t.numeroTarjeta like %?1%")
	public List<Tarjeta> findByNumeroTarjeta(String term);

	@Query("select t from Tarjeta t where t.tipotarjeta.nameTipotarjeta like %?1%")
	public List<Tarjeta> buscarTiptarjeta(String nameTipotarjeta);

	
	@Query("select count(t.numeroTarjeta) from Tarjeta t where t.numeroTarjeta =:numeroTarjeta")
	public int buscarNumeroTarjeta(@Param("numeroTarjeta") String numeroTarjeta);
}
