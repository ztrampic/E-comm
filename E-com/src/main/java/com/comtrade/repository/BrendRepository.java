package com.comtrade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comtrade.entiteti.Brend;
@Repository
public interface BrendRepository extends JpaRepository<Brend, Integer> {
	Brend save(Brend brend);
	
	@Query(value = "select * from brend",nativeQuery = true)
	List<Brend> selectAll();
	
	
	@Query(value = "SELECT * FROM `brend` WHERE id_brand =:id_brand",nativeQuery = true)
	Brend pronadjiBrendZaId(@Param("id_brand") int brendId);
	
	
	

	
	
	

	

	
}
