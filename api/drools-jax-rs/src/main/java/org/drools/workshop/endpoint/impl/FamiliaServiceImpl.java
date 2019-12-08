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

/**
 *
 * @author salaboy
 */
@ApplicationScoped
public class FamiliaServiceImpl implements FamiliaService {

    @Inject
    @KReleaseId(groupId = "org.drools.workshop", artifactId = "drools-user-kjar", version = "1.0-SNAPSHOT")
    @KSession
    private KieSession kSession;

    public FamiliaServiceImpl() {
    }

    /***************************
	* 		Padre - hijo
	***************************/
    @Override
    public List<PadreHijo> getPadreHijos() {
        List<PadreHijo> phs = new ArrayList<>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof PadreHijo) {
                phs.add((PadreHijo) o);
            }
        }
        return phs;
    }

    @Override
    public PadreHijo insertaPH(PadreHijo ph) {
        System.out.println(">> kSession: " + kSession);
        printKieSessionAllFacts(kSession);
        System.out.println(">> User: " + ph);
        kSession.insert(ph);
        int fired = kSession.fireAllRules();
        System.out.println(">> Fired: " + fired);
        return ph;

    }
    
    public String getHtml() {
    	StringBuilder sb = new StringBuilder();
    sb.append("<html xmlns='http://www.w3.org/1999/xhtml'>");sb.append("\n");
    sb.append("<head>");sb.append("\n");
    sb.append("  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");sb.append("\n");
    sb.append("  <title>Users Drools</title>");sb.append("\n");
    sb.append("  <script type='text/javascript'>");sb.append("\n");
    sb.append("    function f() {");sb.append("\n");
    sb.append("       var padre = document.getElementById('element_1').value");sb.append("\n");
    sb.append("        var hijo = document.getElementById('element_2').value ");sb.append("\n");
    sb.append("       xhr = new XMLHttpRequest();");sb.append("\n");
    sb.append("       var url = 'http://localhost:8080/api/familia/inserta/';");sb.append("\n");
    sb.append("       xhr.open('POST', url, true);");sb.append("\n");
    sb.append("       xhr.setRequestHeader('Content-type', 'application/json');");sb.append("\n");
    sb.append("       xhr.setRequestHeader('accept', 'application/json');");sb.append("\n");
    sb.append("       xhr.setRequestHeader('Access-Control-Allow-Origin', 'http://localhost:8080');");sb.append("\n");
    sb.append("       xhr.onreadystatechange = function () { ");sb.append("\n");
    sb.append("           if (xhr.readyState == 4 && xhr.status == 200) {");sb.append("\n");
    sb.append("               var json = JSON.parse(xhr.responseText);");sb.append("\n");
    sb.append("               document.getElementById('salida').innerHTML = xhr.responseText;");sb.append("\n");
    sb.append("       }");sb.append("\n");
    sb.append("      }");sb.append("\n");
    sb.append("      var data = JSON.stringify({'padre': padre,'hijo':hijo});");sb.append("\n");
    sb.append("      xhr.send(data);");sb.append("\n");
    sb.append("    return false;");sb.append("\n");
    sb.append("    }");sb.append("\n");
    sb.append("   </script>");sb.append("\n");
    sb.append("</head>");sb.append("\n");
    sb.append("<body> ");sb.append("\n");
    sb.append("  <h1><a>Users Drools</a></h1>");sb.append("\n");
    sb.append("     <div>");sb.append("\n");
    sb.append("     				<label for='element_1'>Padre</label>");sb.append("\n");
    sb.append("                     <input id='element_1' name='element_1'  type='text' maxlength='255' value=''/> ");sb.append("\n");
    sb.append("     </div>");sb.append("\n");
    sb.append("     <div>");sb.append("\n");
    sb.append("     				<label for='element_2'>Hijo</label>");sb.append("\n");
    sb.append("                     <input id='element_2' name='element_2' class='element text medium' type='text' maxlength='255' value=''/> ");sb.append("\n");
    sb.append("     </div>  ");sb.append("\n");
    sb.append("     <div id= 'salida'> ");sb.append("\n");
    sb.append("     </div> ");sb.append("\n");
    sb.append("  <input type='submit' value = 'Submit' onclick = 'f() '>");sb.append("\n");
    sb.append("  </body>");sb.append("\n");
    sb.append("</html>");sb.append("\n");

    return sb.toString();
        }

    
    /***************************
	* 		Hermanos
	***************************/
    public List<Hermano> getHermanos() {
	List<Hermano> hermanos = new ArrayList<>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Hermano) {
                hermanos.add((Hermano) o);
            }
        }
        return hermanos;
    }
    
    

    
    /***************************
	* 		Abuelos
	***************************/
    @Override
    public List<Abuelo> getAbuelos() {
        List<Abuelo> pa = new ArrayList<>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Abuelo) {
                pa.add((Abuelo) o);
            }
        }
        return pa;
    }
    
    
    /***************************
	* 		Bisabuelos
	***************************/
    @Override
    public List<Bisabuelo> getBisabuelos() {
        List<Bisabuelo> pa = new ArrayList<>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Bisabuelo) {
                pa.add((Bisabuelo) o);
            }
        }
        return pa;
    }
    
    
    /***************************
	* 		Tio-abuelos
	***************************/
    @Override
    public List<Tioabuelo> getTioabuelos() {
        List<Tioabuelo> pa = new ArrayList<>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof Tioabuelo) {
                pa.add((Tioabuelo) o);
            }
        }
        return pa;
    }
    
    
    private void printKieSessionAllFacts(KieSession kSession) {
        System.out.println(" >> Start - Printing All Facts in the Kie Session");
        for (Object o : kSession.getObjects()) {
            System.out.println(">> Fact: " + o);
        }
        System.out.println(" >> End - Printing All Facts in the Kie Session");
    }

}
