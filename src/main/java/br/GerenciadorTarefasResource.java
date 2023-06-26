package br;

/**
 *
 * @author felps
 */
import java.text.SimpleDateFormat;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

//Implementação do web service SOAP
@WebService(endpointInterface = "br.GerenciadorTarefasWebService")
public class GerenciadorTarefasResource implements GerenciadorTarefasWebService {
    private List<Tarefa> tarefas;

    public GerenciadorTarefasResource() {
        tarefas = new ArrayList<>();
    }

    @Override
    public void adicionarTarefa(String descricao) {
        Tarefa tarefa = new Tarefa(descricao);
        tarefas.add(tarefa);
    }

    @Override
    public boolean removerTarefa(int id) {
        if (id >= 0 && id < tarefas.size()) {
            tarefas.remove(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String listarTarefas() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tarefas.size(); i++) {
            Tarefa tarefa = tarefas.get(i);
            sb.append(i).append(". ").append(tarefa.getDescricao())
            .append(" (Data: ").append(dateFormat.format(tarefa.getData())).append(")\n");
    }
    return sb.toString();
}

    @Override
    public void adicionarTarefaComData(Tarefa tarefa) {
        tarefas.add(tarefa);
    }
}
