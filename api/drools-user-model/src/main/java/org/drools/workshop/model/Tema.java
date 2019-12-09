package org.drools.workshop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tema {
    private List<Problema> problema;
    private int nivel;
    static Random random = new Random();
    private String nombre;

    public Tema() {
        problema  = new ArrayList<Problema>();
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setProblema(List<Problema> ps) {
        problema = ps;
    }

    public List<Problema> getProblema() {
        return problema;
    }

}