package br;

/**
 *
 * @author felps
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.xml.ws.Endpoint;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            // Configuração do RMI
            GerenciadorTarefas gerenciadorTarefasRMI = new GerenciadorTarefasImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("GerenciadorTarefas", (Remote) gerenciadorTarefasRMI);

            // Configuração do WebService
            String address = "http://localhost:8080/gerenciadortarefas";
            Endpoint.publish(address, new GerenciadorTarefasResource());

            System.out.println("Servidor iniciado");
        } catch (RemoteException e) {
            System.out.println("Erro ao iniciar o servidor: " + e.getMessage());
            System.out.println(e);
        }
    }
}
