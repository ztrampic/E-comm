package com.comtrade.servisi;

import com.comtrade.entiteti.Kupac;
import com.comtrade.repository.KupacLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KupacLoginServisImpl implements KupacLoginServis{

    private KupacLoginRepository kupacLoginRepository;
    @Autowired
    public KupacLoginServisImpl(KupacLoginRepository kupacLoginRepository) {
        this.kupacLoginRepository = kupacLoginRepository;
    }


    @Override
    @Transactional
    public Kupac tryLogin(Kupac kupac) {
        String mail = kupac.getEmail();
        String pass = kupac.getPassword();
        Kupac k = kupacLoginRepository.tryLogin(mail,pass);

        return k;
    }
}
