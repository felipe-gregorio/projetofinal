package br;

/**
 *
 * @author felps
 */
import javax.xml.ws.Service;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.xml.namespace.QName;

public class Cliente {

    public static void main(String[] args) {
        try {
            //URL do WSDL do serviço web
            URL url = new URL("http://localhost:8080/gerenciadortarefas?wsdl");
            //Nome do serviço e da porta definidos no WSDL
            QName qname = new QName("http://br/", "GerenciadorTarefasResourceService");
            QName qnametmp = new QName("http://br/", "GerenciadorTarefasResourcePort");
            //Criação do serviço a partir da URL e do nome do serviço
            Service service = Service.create(url, qname);

            //Obtenção do proxy para serviço web
            GerenciadorTarefasWebService gerenciadorTarefas = service.getPort(qnametmp,
                    GerenciadorTarefasWebService.class);

            //criação do menu de opções
            Scanner scanner = new Scanner(System.in);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            while (true) {
                System.out.println("===== MENU =====");
                System.out.println("1. Adicionar Tarefa");
                System.out.println("2. Remover Tarefa");
                System.out.println("3. Listar Tarefas");
                System.out.println("4. Sair");
                System.out.println("================");
                System.out.println("Escolha uma opção: ");

                String menu = scanner.nextLine();

                if (menu.equals("4")) {
                    break;
                }

                switch (menu) {
                    case "1":
                        System.out.println("Digite a descrição da tarefa:");
                        String descricao = scanner.nextLine();
                        System.out.println("Digite a data da tarefa (formato: dd/MM/yyyy):");
                        String dataString = scanner.nextLine();
                        try {
                            Date data = dateFormat.parse(dataString);
                            Tarefa tarefa = new Tarefa(descricao, data);
                            gerenciadorTarefas.adicionarTarefaComData(tarefa);
                            System.out.println("<<<<Tarefa adicionada com sucesso!>>>>");
                        } catch (java.text.ParseException e) {
                            System.out.println("Formato de data inválido. Digite no formato dd/MM/yyyy.");
                        }
                        break;
                    case "2":
                        System.out.println("Digite o ID da tarefa a ser removida:");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        boolean tarefaRemovida = gerenciadorTarefas.removerTarefa(id);
                        if (tarefaRemovida) {
                            System.out.println("<<<<Tarefa removida com sucesso!>>>>");
                        } else {
                            System.out.println("Falha ao remover a tarefa. Verifique o ID da tarefa.");
                        }
                        break;
                    case "3":
                        System.out.println("Listagem de Tarefas:\n");
                        String listaTarefas = gerenciadorTarefas.listarTarefas();
                        System.out.println(listaTarefas);
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao executar a requisição: " + e.getMessage());
            System.out.println(e);
        }
    }
}
