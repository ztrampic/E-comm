package com.comtrade.servisi;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.comtrade.entiteti.Brend;

public interface BrendService {
	public void save(Brend brend);
	List<Brend>selectAll();
	public void deleteBrend(Integer id);
	public Brend findBrendById(int brendId);
	
	
}
