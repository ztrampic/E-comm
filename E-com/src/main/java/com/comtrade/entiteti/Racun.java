package com.comtrade.entiteti;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NaturalId;
@Entity
public class Racun {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_racun;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_kupac")
	private Kupac kupac;
	@NaturalId
	private String brojracuna;
	@Temporal(TemporalType.DATE)
	private Date datum;
	@OneToMany(mappedBy = "racun",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Stavke>listaStavki = new ArrayList<>();
	public int getId_racun() {
		return id_racun;
	}
	public void setId_racun(int id_racun) {
		this.id_racun = id_racun;
	}
	public Kupac getKupac() {
		return kupac;
	}
	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}
	public String getBrojracuna() {
		return brojracuna;
	}
	public void setBrojracuna(String brojracuna) {
		this.brojracuna = brojracuna;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public List<Stavke> getListaStavki() {
		return listaStavki;
	}
	public void setListaStavki(List<Stavke> listaStavki) {
		this.listaStavki = listaStavki;
	}
	
	public void dodajStavke(Stavke stavke) {
		listaStavki.add(stavke);
		stavke.setRacun(this);
		
	}
	
	public void obrisiStavke(Stavke stavke) {
		listaStavki.remove(stavke);
		stavke.setRacun(null);
	}
	
}
