package org.drools.workshop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tema {
    private List<Problema> problema;
    private Integer nivel;
    static Random random = new Random();

    public Tema() {
        problema  = new ArrayList<Problema>();
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setProblema(List<Problema> ps) {
        problema = ps;
    }

    public Problema elegirProblema() {
        return problema.get(random.nextInt(problema.size()));
    }

}