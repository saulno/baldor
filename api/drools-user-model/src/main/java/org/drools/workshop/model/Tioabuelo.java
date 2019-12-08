package org.drools.workshop.model;

import javax.xml.bind.annotation.XmlRootElement;

public class Tioabuelo {
	private String tioabuelo;
	private String bisnieto;
	
	public Tioabuelo() {};
	
	public Tioabuelo(String tioabuelo, String bisnieto) {
		this.setTioabuelo(tioabuelo);
		this.setBisnieto(bisnieto);
	}
	
	public String getTioabuelo() {
		return this.tioabuelo;
	}
	
	public String getBisnieto() {
		return this.bisnieto;
	}
	
	public void setTioabuelo(String tioabuelo) {
		this.tioabuelo = tioabuelo;
	}
	
	public void setBisnieto(String bisnieto) {
		this.bisnieto = bisnieto;
	}
	
	@Override
	public String toString() {
		return "Tioabuelo{" + "tioabuelo=" + this.getTioabuelo() + ", bisnieto=" + this.getBisnieto() + "}";
	}
}