package com.comtrade.repository;

import com.comtrade.entiteti.Racun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RacunRepository extends JpaRepository<Racun,Integer> {

    @Query(value = "SELECT MAX(brojracuna) FROM racun",nativeQuery = true)
    Integer nadjiPoslednjiBrRacuna();

}
