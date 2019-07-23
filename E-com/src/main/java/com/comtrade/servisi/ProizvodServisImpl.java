package com.comtrade.servisi;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comtrade.entiteti.Proizvod;
import com.comtrade.repository.ProizvodRepository;

@Service
public class ProizvodServisImpl implements ProizvodServis {
	
	private ProizvodRepository proizvodRepozitory;
	
	@Autowired
	public ProizvodServisImpl(ProizvodRepository proizvodRepozitory) {
		super();
		this.proizvodRepozitory = proizvodRepozitory;
	}

	@Override
	@Transactional
	public List<Proizvod> selectAll() {
		Collection<Proizvod>sve = proizvodRepozitory.selectALL();
		return (List<Proizvod>) sve;
	}


	@Override
	@Transactional
	public void save(Proizvod proizvod) {
		proizvodRepozitory.save(proizvod);
		
	}

	@Override
	@Transactional
	public List<Proizvod> sviProizvodiZaIdBrenda(int brendId) {
		List<Proizvod> list = proizvodRepozitory.getAllByIdBrend(brendId);
		return list;
	}

	@Override
	@Transactional
	public Proizvod findProizvodById(Integer id) {
		Proizvod proizvod = proizvodRepozitory.findProizvodById(id);
		return proizvod;
	}


}
