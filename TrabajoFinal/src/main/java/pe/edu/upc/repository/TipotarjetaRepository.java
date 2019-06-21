package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Tipotarjeta;
@Repository
public interface TipotarjetaRepository extends JpaRepository<Tipotarjeta, Integer> {


	@Query("select count(t.nameTipotarjeta) from Tipotarjeta t where t.nameTipotarjeta =:nameTipotarjeta")
	public int buscarNombreTipotarjeta ( @Param ("nameTipotarjeta") String nameTipotarjeta);
	
	
	@Query("from Tipotarjeta t where t.nameTipotarjeta like %:nameTipotarjeta%")
	List<Tipotarjeta> findbynombreTipotarejta(String nameTipotarjeta);

	
	
}
