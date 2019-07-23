package com.comtrade.servisi;

import com.comtrade.entiteti.Racun;

public interface RacunServis {
    public void save(Racun racun);

    Integer nadjiPoslednjiBrRacuna();
}
