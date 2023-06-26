package br;

/**
 *
 * @author felps
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

//interface remota RMI
public interface GerenciadorTarefas extends Remote {
    void adicionarTarefa(String descricao) throws RemoteException;

    boolean removerTarefa(int id) throws RemoteException;

    String listarTarefas() throws RemoteException;
}
