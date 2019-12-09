package org.drools.workshop.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Respuesta {
    private String username;
    private boolean esCorrecto;

    public Respuesta() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public boolean getEsCorrecto() {
        return esCorrecto;
    }

    public void setEsCorrecto(boolean respuesta) {
        this.esCorrecto = respuesta;
    }
}