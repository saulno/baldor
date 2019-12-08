package org.drools.workshop.model;

import javax.xml.bind.annotation.XmlRootElement;

public class Bisabuelo {
	private String bisabuelo;
	private String bisnieto;
	
	public Bisabuelo() {};
	
	public Bisabuelo(String bisabuelo, String bisnieto) {
		this.setBisabuelo(bisabuelo);
		this.setBisnieto(bisnieto);
	}
	
	public String getBisabuelo() {
		return this.bisabuelo;
	}
	
	public String getBisnieto() {
		return this.bisnieto;
	}
	
	public void setBisabuelo(String bisabuelo) {
		this.bisabuelo = bisabuelo;
	}
	
	public void setBisnieto(String bisnieto) {
		this.bisnieto = bisnieto;
	}
	
	@Override
	public String toString() {
		return "Bisabuelo{" + "bisabuelo=" + this.getBisabuelo() + ", bisnieto=" + this.getBisnieto() + "}";
	}
}