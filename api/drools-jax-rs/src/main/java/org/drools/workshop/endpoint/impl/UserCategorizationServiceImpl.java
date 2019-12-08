package org.drools.workshop.endpoint.impl;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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

    public UserCategorizationServiceImpl() {
    }

    @Override
    public User categorizeUser(User user) {
        System.out.println(">> kSession: " + kSession);
        printKieSessionAllFacts(kSession);
        System.out.println(">> User: " + user);
        kSession.insert(user);
        int fired = kSession.fireAllRules();
        System.out.println(">> Fired: " + fired);
        return user;

    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof User) {
                users.add((User) o);
            }
        }
        return users;
    }

    private void printKieSessionAllFacts(KieSession kSession) {
        System.out.println(" >> Start - Printing All Facts in the Kie Session");
        for (Object o : kSession.getObjects()) {
            System.out.println(">> Fact: " + o);
        }
        System.out.println(" >> End - Printing All Facts in the Kie Session");
    }

    public String getHtml() {
	StringBuilder sb = new StringBuilder();
sb.append("<html xmlns='http://www.w3.org/1999/xhtml'>");sb.append("\n");
sb.append("<head>");sb.append("\n");
sb.append("  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");sb.append("\n");
sb.append("  <title>Users Drools</title>");sb.append("\n");
sb.append("  <script type='text/javascript'>");sb.append("\n");
sb.append("    function f() {");sb.append("\n");
sb.append("       var name = document.getElementById('element_1').value");sb.append("\n");
sb.append("        var age = document.getElementById('element_2').value ");sb.append("\n");
sb.append("       xhr = new XMLHttpRequest();");sb.append("\n");
sb.append("       var url = 'http://localhost:8080/api/users/categorize/';");sb.append("\n");
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
sb.append("      var data = JSON.stringify({'name': name,'age':age});");sb.append("\n");
sb.append("      xhr.send(data);");sb.append("\n");
sb.append("    return false;");sb.append("\n");
sb.append("    }");sb.append("\n");
sb.append("   </script>");sb.append("\n");
sb.append("</head>");sb.append("\n");
sb.append("<body> ");sb.append("\n");
sb.append("  <h1><a>Users Drools</a></h1>");sb.append("\n");
sb.append("     <div>");sb.append("\n");
sb.append("                     <input id='element_1' name='element_1'  type='text' maxlength='255' value=''/> ");sb.append("\n");
sb.append("     </div>");sb.append("\n");
sb.append("     <div>");sb.append("\n");
sb.append("                     <input id='element_2' name='element_2' class='element text medium' type='text' maxlength='255' value=''/> ");sb.append("\n");
sb.append("     </div>  ");sb.append("\n");
sb.append("     <div id= 'salida'> ");sb.append("\n");
sb.append("     </div> ");sb.append("\n");
sb.append("  <input type='submit' value = 'Submit' onclick = 'f() '>");sb.append("\n");
sb.append("  </body>");sb.append("\n");
sb.append("</html>");sb.append("\n");

return sb.toString();
    }

}
