package com.comtrade.servisi;

import java.util.List;

import com.comtrade.entiteti.Proizvod;

public interface ProizvodServis {

	List<Proizvod> selectAll();


	public void save(Proizvod proizvod);

	List<Proizvod> sviProizvodiZaIdBrenda(int brendId);

	Proizvod findProizvodById(Integer id);


}
