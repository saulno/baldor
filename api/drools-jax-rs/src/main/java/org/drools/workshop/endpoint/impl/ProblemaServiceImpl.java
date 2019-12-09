package org.drools.workshop.endpoint.impl;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.drools.workshop.model.*;

import org.drools.workshop.endpoint.api.*;
import org.kie.api.cdi.KReleaseId;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;

@ApplicationScoped
public class ProblemaServiceImpl implements ProblemaService {
    @Inject
    @KReleaseId(groupId = "org.drools.workshop", artifactId = "drools-user-kjar", version = "1.0-SNAPSHOT")
    @KSession
    private KieSession kSession;

    public ProblemaServiceImpl() {
    }

    @Override
    public Problema actualizarProblemas() {
        List<Tema> ts = new ArrayList<Tema>();
        Tema t = new Tema();
        List<Problema> ps = new ArrayList<Problema>();
        Problema p = new Problema();


        t.setNivel(0);
        t.setNombre("Sumas basicas polinomios");

        p.setInstruccion("Reducir el siguiente polinomio.");
		p.setEcuacion("A * a + B * b + C * a + D * b");
        p.setRespuesta("a^1 = A + C, b^1 = B + D", "reduccion");
        ps.add(p);

        p = new Problema();
        p.setInstruccion("Reducir el siguiente polinomio.");
        p.setEcuacion("1 - ((A * a + B * c) + (C * a + D * c))");
        p.setRespuesta("a^1 = -1 * (A + C), c^1 = 1 - B - D", "reduccion");
        ps.add(p);

        p = new Problema();
        p.setInstruccion("Obten el valor de x.");
        p.setEcuacion("A * x = B * x + C");
        p.setRespuesta("x^1 = C / (A - B)", "despeje");
        ps.add(p);

        // AGREGADOS ALI 

        p = new Problema();
        p.setInstruccion("Reducir el siguiente Polinomio.");
        p.setEcuacion("A * a - B * a");
        p.setRespuesta("a^​1 = A * B", "reduccion");
        ps.add(p);

        p = new Problema();
        p.setInstruccion("Reducir el siguiente Polinomio.");
        p.setEcuacion("A * a + B * a + C * b");
        p.setRespuesta("a^​1 = A + B, b^​1 = C", "reduccion");
        ps.add(p);

        p = new Problema();
        p.setInstruccion("Reducir el siguiente Polinomio.");
        p.setEcuacion("A * a - B * b - C * b + D * a - E * c");
        p.setRespuesta("a^​1 = A + D, b^​1 = -C - B, c^​1 = E", "reduccion");
        ps.add(p);

        // Despejes
        p = new Problema();
        p.setInstruccion("Obten el valor de x.");
        p.setEcuacion("A * x = B * x - C");
        p.setRespuesta("x^1 = (-C) / (A - B)", "despeje");
        ps.add(p);

        //TTT
        t.setProblema(ps);
        ts.add(t);


        for (Tema tema : ts) {
            kSession.insert(tema);
        }

        p = new Problema();
        p.setInstruccion("Se han actualizado los temas correctamente.");
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