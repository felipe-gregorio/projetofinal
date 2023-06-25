package br;

/**
 *
 * @author felps
 */

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//Interface que define os métodos que o web service irá expor
@WebService
public interface GerenciadorTarefasWebService {

    @WebMethod
    @POST
    @Path("/adicionarTarefa")
    @Consumes(MediaType.TEXT_PLAIN)
    void adicionarTarefa(String descricao);

    @WebMethod
    @DELETE
    @Path("/removerTarefa/{id}")
    void removerTarefa(@PathParam("id") int id);

    @WebMethod
    @GET
    @Path("/listarTarefas")
    @Produces(MediaType.TEXT_PLAIN)
    String listarTarefas();
    
    @WebMethod
    @POST
    @Path("/adicionarTarefaComData")
    @Consumes(MediaType.APPLICATION_JSON)
    void adicionarTarefaComData(Tarefa tarefa);
}
