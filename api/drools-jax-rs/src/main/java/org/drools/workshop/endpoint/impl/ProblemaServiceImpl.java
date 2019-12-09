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
    public List<Problema> getProblemas() {
        List<Problema> ps = new ArrayList<>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Problema) {
                ps.add((Problema) o);
            }
        }
        return ps;
    }

    @Override
    public Problema insertaProblema(Problema p) {
        System.out.println(">> kSession: " + kSession);
        printKieSessionAllFacts(kSession);
        System.out.println(">> Problema: " + p);
        kSession.insert(p);
        int fired = kSession.fireAllRules();
        System.out.println(">> Fired: " + fired);
        return p;

    }

    @Override
    public Problema actualizarProblemas() {
        List<Problema> ps = new ArrayList<Problema>();
        Problema p = new Problema();

		p.setInstruccion("Reducir el siguiente polinomio.");
		p.setEcuacion("A * a + B * b + C * a + D * b");
        p.setRespuesta("a^1 = A + C, b^1 = B + D");
        ps.add(p);

        for (Problema pro : ps) {
            kSession.insert(pro);
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