package com.comtrade.entiteti;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kupac {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_kupac;
	private String ime;
	private String prezime;
	private String email;
	private String password;
	public int getId_kupac() {
		return id_kupac;
	}
	public void setId_kupac(int id_kupac) {
		this.id_kupac = id_kupac;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
