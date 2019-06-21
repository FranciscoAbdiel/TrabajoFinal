package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
	
@Query("from Categoria ca where ca.nombreCategoria like %:nombreCategoria%")	
List<Categoria> findByNombreCategoria(String nombreCategoria);

@Query("select count(c.nombreCategoria) from Categoria c where c.nombreCategoria =:nombreCategoria")
public int buscarNombreCategoria(@Param("nombreCategoria")String nombreCategoria);
}
