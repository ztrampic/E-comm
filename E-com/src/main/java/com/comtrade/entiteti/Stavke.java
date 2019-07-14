package com.comtrade.entiteti;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Stavke {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int kolicina;
	private int brStavke;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_racun")
	private Racun racun;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proizvoda")
	private Proizvod proizvod;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	public int getBrStavke() {
		return brStavke;
	}
	public void setBrStavke(int brStavke) {
		this.brStavke = brStavke;
	}
	public Racun getRacun() {
		return racun;
	}
	public void setRacun(Racun racun) {
		this.racun = racun;
	}
	public Proizvod getProizvod() {
		return proizvod;
	}
	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}
	
	
}
