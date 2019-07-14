package com.comtrade.servisi;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comtrade.entiteti.Brend;
import com.comtrade.repository.BrendRepository;
@Service
public class BrendServiceImpl implements BrendService {
	
	private BrendRepository brendRepository;
	
	@Autowired
	public BrendServiceImpl(BrendRepository brendRepository) {
		super();
		this.brendRepository = brendRepository;
	}


	@Override
	@Transactional
	public void save(Brend brend) {
		brendRepository.save(brend);

	}


	@Override
	@Transactional
	public List<Brend> selectAll() {
		List<Brend>sve = brendRepository.selectAll();
		return sve;
	}


	@Override
	@Transactional
	public void deleteBrend(Integer id) {
		brendRepository.deleteById(id);
		
	}


	@Override
	@Transactional
	public Brend findBrendById(int brendId) {
		Brend b = new Brend();
		b= brendRepository.pronadjiBrendZaId(brendId);
		return b;
	}


	


	


	

}
