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
    private List<Tarefa> tarefas;

    public GerenciadorTarefasImpl() throws RemoteException {
        super();
        tarefas = new ArrayList<>();
    }

    @Override
    public void adicionarTarefa(String descricao) throws RemoteException {
        Tarefa tarefa = new Tarefa(descricao);
        tarefas.add(tarefa);
        System.out.println("Tarefa adicionada: " + descricao);
    }

    @Override
    public void removerTarefa(int id) throws RemoteException {
        if (id >= 0 && id < tarefas.size()) {
            Tarefa descricao = tarefas.remove(id);
            System.out.println("Tarefa removida: " + descricao);
        } else {
            System.out.println("ID de tarefa inválido");
        }
    }

    @Override
    public String listarTarefas() throws RemoteException {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Tarefas:\n");
        for (int i = 0; i < tarefas.size(); i++) {
            Tarefa tarefa = tarefas.get(i);
            sb.append(i).append(": ").append(tarefa.getDescricao()).append("\n");
        }
        return sb.toString();
    }
    
    
}
