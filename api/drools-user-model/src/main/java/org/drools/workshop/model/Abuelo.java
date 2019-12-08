package org.drools.workshop.model;

import javax.xml.bind.annotation.XmlRootElement;

public class Abuelo {
	private String abuelo;
	private String nieto;
	
	public Abuelo() {};
	
	public Abuelo(String abuelo, String nieto) {
		this.setAbuelo(abuelo);
		this.setNieto(nieto);
	}
	
	public String getAbuelo() {
		return this.abuelo;
	}
	
	public String getNieto() {
		return this.nieto;
	}
	
	public void setAbuelo(String abuelo) {
		this.abuelo = abuelo;
	}
	
	public void setNieto(String nieto) {
		this.nieto = nieto;
	}
	
	@Override
	public String toString() {
		return "Abuelo{" + "abuelo=" + this.getAbuelo() + ", nieto=" + this.getNieto() + "}";
	}
}