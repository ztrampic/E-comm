package com.comtrade.repository;

import com.comtrade.entiteti.Kupac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KupacRepository extends JpaRepository<Kupac, Integer> {

    @Query(value = "SELECT * FROM `kupac` WHERE id_kupac =:id_kupac",nativeQuery = true)
    Kupac findKupacById(@Param("id_kupac") Integer id_kupac);

}
