package com.comtrade.servisi;

import com.comtrade.entiteti.Kupac;
import com.comtrade.repository.KupacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KupacServisImpl implements KupacServis{

    private KupacRepository kupacRepository;
    @Autowired
    public KupacServisImpl(KupacRepository kupacRepository) {
        this.kupacRepository = kupacRepository;
    }

    @Override
    @Transactional
    public Kupac findKupacById(Integer idKupca) {
        return kupacRepository.findKupacById(idKupca);
    }
}
