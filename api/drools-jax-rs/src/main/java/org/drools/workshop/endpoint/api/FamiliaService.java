/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drools.workshop.endpoint.api;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.drools.workshop.model.*;

/**
 *
 * @author salaboy
 */
@Path("familia")
public interface FamiliaService {
	/***************************
	* 		Padre - hijo
	***************************/
	@GET
    @Produces("application/json")
    @Path("")
    public List<PadreHijo> getPadreHijos();
	
	@POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/inserta")
    public PadreHijo insertaPH(@NotNull PadreHijo ph);
	
	@GET
	@Produces("text/html")
	@Path("html")
	public String getHtml();
	
	
	/***************************
	* 		Hermanos
	***************************/
    @GET
    @Produces("application/json")
    @Path("/hermanos")
    public List<Hermano> getHermanos();
    
    
    /***************************
	* 		Abuelos
	***************************/
    @GET
    @Produces("application/json")
    @Path("/abuelos")
    public List<Abuelo> getAbuelos();
    
    /***************************
	* 		Bisabuelos
	***************************/
    @GET
    @Produces("application/json")
    @Path("/bisabuelos")
    public List<Bisabuelo> getBisabuelos();
    
    /***************************
	* 		Tio-abuelos
	***************************/
    @GET
    @Produces("application/json")
    @Path("/tioabuelos")
    public List<Tioabuelo> getTioabuelos();
}
