/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drools.workshop.model;

import java.util.List;
import java.util.Random;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    
    private String username;
    private int progreso;
    private int nivel;
    private List<Problema> problema;
    static Random random = new Random();

    public User() {
        progreso = 0;
        nivel = 0;
        username = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProgreso(int progreso) {
        if (progreso >= 3) {
            subirNivel();
            this.progreso = 0;
        } else if (progreso <= 3) {
            bajarNivel();
            this.progreso = 0;
        } else {
            this.progreso = progreso;
        }
    }

    public int getProgreso() {
        return progreso;
    }

    public int getNivel() {
        return nivel;
    }

    public void subirNivel() {
        this.nivel +=1;
    }

    public void bajarNivel() {
        if (this.nivel > 0) {
            this.nivel -= 1;
        }
    }

    public Problema elegirProblema() {
        return problema.get(random.nextInt(problema.size()));
    }

    public void setProblema(List<Problema> problema) {
        this.problema = problema;
    }

    public void registrarRespuesta(boolean esCorrecta) {
        if (esCorrecta) {
            setProgreso(progreso + 1);
        } else {
            setProgreso(progreso - 1);
        }
    }

    @Override
    public String toString() {
        return "User{" +    "\nusername=" + username + 
                            ",\nprogreso=" + progreso +
        '}';
    }

   
    
    
}
