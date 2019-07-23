package com.comtrade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comtrade.entiteti.Proizvod;

@Repository
public interface ProizvodRepository extends CrudRepository<Proizvod, Integer> {
	@Query(value = "select * from proizvod",nativeQuery = true)
	List<Proizvod> selectALL();
	
	@Query(value = "SELECT * FROM `proizvod` WHERE id_brand =:id_brand",nativeQuery = true)
	List<Proizvod> getAllByIdBrend(@Param("id_brand")int brendId);

	@Query(value = "SELECT * FROM `proizvod` WHERE id_proizvod =:id_proizvod",nativeQuery = true)
    Proizvod findProizvodById(@Param("id_proizvod") Integer id_proizvod);
}
