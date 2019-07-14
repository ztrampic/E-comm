package com.comtrade.entiteti;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Proizvod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_proizvod;
	private String naziv;
	private double cena;
	private String nazivSlike;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_brand")
	private Brend brend;
	public int getId_proizvod() {
		return id_proizvod;
	}
	public void setId_proizvod(int id_proizvod) {
		this.id_proizvod = id_proizvod;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public Brend getBrend() {
		return brend;
	}
	public void setBrend(Brend brend) {
		this.brend = brend;
	}

	public String getNazivSlike() {
		return nazivSlike;
	}
	public void setNazivSlike(String nazivSlike) {
		this.nazivSlike = nazivSlike;
	}
	
	
	
	
}
