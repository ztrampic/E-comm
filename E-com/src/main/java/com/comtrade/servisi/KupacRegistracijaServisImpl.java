package com.comtrade.servisi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comtrade.entiteti.Kupac;
import com.comtrade.repository.RegistracijaRepository;
@Service
public class KupacRegistracijaServisImpl implements KupacRgistracijaServis {
	
	private RegistracijaRepository registracijaRepository;
	
	@Autowired
	public KupacRegistracijaServisImpl(RegistracijaRepository registracijaRepository) {
		super();
		this.registracijaRepository = registracijaRepository;
	}


	@Override
	@Transactional
	public void save(Kupac kupac) {
		registracijaRepository.save(kupac);

	}

}
