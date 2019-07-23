package com.comtrade.servisi;

import com.comtrade.entiteti.Racun;
import com.comtrade.repository.RacunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RacunServisImpl implements RacunServis{

    private RacunRepository racunRepository;
    @Autowired
    public RacunServisImpl(RacunRepository racunRepository) {
        this.racunRepository = racunRepository;
    }

    @Override
    @Transactional
    public void save(Racun racun) {
    racunRepository.save(racun);
    }

    @Override
    @Transactional
    public Integer nadjiPoslednjiBrRacuna() {
        Integer broj = racunRepository.nadjiPoslednjiBrRacuna();
        return broj;
    }
}
