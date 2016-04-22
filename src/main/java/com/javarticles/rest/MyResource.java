package com.javarticles.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consultorio.dominio.Atendimento;
import consultorio.repositorio.AtendimentoRepository;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
	
	private final  AtendimentoRepository repository = new AtendimentoRepository();

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	
    	Atendimento atendimento = new Atendimento();
    	
    	repository.Salvar(atendimento);
    	
        return "Got it!";
    }
}
