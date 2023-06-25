package br;

/**
 *
 * @author felps
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GerenciadorTarefas extends Remote {
    void adicionarTarefa(String descricao) throws RemoteException;

    void removerTarefa(int id) throws RemoteException;

    String listarTarefas() throws RemoteException;
}
