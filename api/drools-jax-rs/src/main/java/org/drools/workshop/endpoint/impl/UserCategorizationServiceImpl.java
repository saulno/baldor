package org.drools.workshop.endpoint.impl;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import org.drools.workshop.model.Problema;
import org.drools.workshop.model.Respuesta;
import org.drools.workshop.model.User;

import org.drools.workshop.endpoint.api.UserCategorizationService;
import org.kie.api.cdi.KReleaseId;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;

/**
 *
 * @author salaboy
 */
@ApplicationScoped
public class UserCategorizationServiceImpl implements UserCategorizationService {

    @Inject
    @KReleaseId(groupId = "org.drools.workshop", artifactId = "drools-user-kjar", version = "1.0-SNAPSHOT")
    @KSession
    private KieSession kSession;

    public User responderPregunta(Respuesta respuesta) {
        User usr = new User();
        for(Object o : kSession.getObjects()) {
            if (o instanceof User) {
                User u = (User) o;
                if (respuesta.getUsername().equals(u.getUsername())) {
                    u.registrarRespuesta(respuesta.getEsCorrecto());
                    usr = u;
                }
            }
        }

        System.out.println(">> kSession: " + kSession);
        printKieSessionAllFacts(kSession);
        System.out.println(">> Usuario: " + usr);
        kSession.insert(usr);
        int fired = kSession.fireAllRules();
        System.out.println(">> Fired: " + fired);
        return usr;
    }

    public UserCategorizationServiceImpl() {
    }

    @Override
    public User registrarUsuario(User user) {
        boolean encontrado = false;
        User loginUsuario = new User();

        for(Object o : kSession.getObjects()) {
            if (o instanceof User) {
                User u = (User) o;
                if (user.getUsername().equals(u.getUsername())) {
                    encontrado = true;
                    loginUsuario = (User) o;
                }
            }
        }

        if (encontrado) {
            return loginUsuario;
        } else {    
            System.out.println(">> kSession: " + kSession);
            printKieSessionAllFacts(kSession);
            System.out.println(">> Usuario: " + user);
            kSession.insert(user);
            int fired = kSession.fireAllRules();
            System.out.println(">> Fired: " + fired);
            return user;
        }
    }

    @Override
    public Problema elegirProblema(User user) {
        Problema p = new Problema();

        for(Object o : kSession.getObjects()) {
            if (o instanceof User) {
                User u = (User) o;
                if (user.getUsername().equals(u.getUsername())) {
                   p = u.elegirProblema();
                }
            }
        }

        return p;
    }

    private void printKieSessionAllFacts(KieSession kSession) {
        System.out.println(" >> Start - Printing All Facts in the Kie Session");
        for (Object o : kSession.getObjects()) {
            System.out.println(">> Fact: " + o);
        }
        System.out.println(" >> End - Printing All Facts in the Kie Session");
    }

}
