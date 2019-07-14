package com.comtrade.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comtrade.entiteti.Kupac;
@Repository
public interface RegistracijaRepository extends CrudRepository<Kupac, Integer>{
	Kupac save(Kupac kupac);
}
