package br;

/**
 *
 * @author felps
 */
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "gerenciadortarefas.GerenciadorTarefasWebService")
public class GerenciadorTarefasResource implements GerenciadorTarefasWebService {
    private List<String> tarefas;

    public GerenciadorTarefasResource() {
        tarefas = new ArrayList<>();
    }

    @Override
    public void adicionarTarefa(String descricao) {
        tarefas.add(descricao);
    }

    @Override
    public void removerTarefa(int id) {
        if (id >= 0 && id < tarefas.size()) {
            tarefas.remove(id);
        }
    }

    @Override
    public String listarTarefas() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tarefas.size(); i++) {
            sb.append(i).append(". ").append(tarefas.get(i)).append("\n");
        }
        return sb.toString();
    }
}
