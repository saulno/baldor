/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drools.workshop.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    
    private String username;
    private Integer progreso;

    public User() {
        progreso = 0;
        username = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getProgreso() {
        return progreso;
    }

    public void registrarRespuesta(boolean esCorrecta) {
        if (esCorrecta) {
            progreso += 1;
        } else {
            progreso -= 1;
        }
    }

    @Override
    public String toString() {
        return "User{" +    "\nusername=" + username + 
                            ",\nprogreso=" + progreso +
        '}';
    }

   
    
    
}
