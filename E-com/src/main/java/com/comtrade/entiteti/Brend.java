package com.comtrade.entiteti;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Brend {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_brand;
	private String naziv;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "brend")
	private List<Proizvod>listProizvoda = new ArrayList<Proizvod>();
	private String nazivSlike;
	private String opis;
	
	
	
	
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getNazivSlike() {
		return nazivSlike;
	}
	public void setNazivSlike(String nazivSlike) {
		this.nazivSlike = nazivSlike;
	}
	public String getOpis() {
		return opis;
	}
	public int getId_brand() {
		return id_brand;
	}
	public void setId_brand(int id_brand) {
		this.id_brand = id_brand;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public List<Proizvod> getListProizvoda() {
		return listProizvoda;
	}
	public void setListProizvoda(List<Proizvod> listProizvoda) {
		this.listProizvoda = listProizvoda;
	}
	
	public void addProizvod(Proizvod proizvod) {
		listProizvoda.add(proizvod);
		proizvod.setBrend(this);
	}
	
	public void removeProizvod(Proizvod proizvod) {
		listProizvoda.remove(proizvod);
		proizvod.setBrend(null);
	}
	
	
	
}
