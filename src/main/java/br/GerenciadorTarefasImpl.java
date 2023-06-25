package br;

/**
 *
 * @author felps
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefasImpl extends UnicastRemoteObject implements GerenciadorTarefas {
    private List<String> tarefas;

    public GerenciadorTarefasImpl() throws RemoteException {
        super();
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) throws RemoteException {
        tarefas.add(descricao);
        System.out.println("Tarefa adicionada: " + descricao);
    }

    public void removerTarefa(int id) throws RemoteException {
        if (id >= 0 && id < tarefas.size()) {
            String descricao = tarefas.remove(id);
            System.out.println("Tarefa removida: " + descricao);
        } else {
            System.out.println("ID de tarefa inválido");
        }
    }

    public String listarTarefas() throws RemoteException {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Tarefas:\n");
        for (int i = 0; i < tarefas.size(); i++) {
            sb.append(i).append(": ").append(tarefas.get(i)).append("\n");
        }
        return sb.toString();
    }
}
