package br;

/**
 *
 * @author felps
 */
import javax.xml.ws.Service;
import java.net.URL;
import java.util.Scanner;

import javax.xml.namespace.QName;

public class Cliente {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/gerenciadortarefas?wsdl");
            QName qname = new QName("http://gerenciadortarefas/", "GerenciadorTarefasResourceService");
            QName qnametmp = new QName("http://gerenciadortarefas/", "GerenciadorTarefasResourcePort");
            Service service = Service.create(url, qname);
            GerenciadorTarefasWebService gerenciadorTarefas = service.getPort(qnametmp,
                    GerenciadorTarefasWebService.class);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("===== MENU =====");
                System.out.println("1. Adicionar Tarefa");
                System.out.println("2. Remover Tarefa");
                System.out.println("3. Listar Tarefas");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");

                String menu = scanner.nextLine();

                if (menu.equals("4")) {
                    break;
                }

                switch (menu) {
                    case "1":
                        System.out.println("Digite a descrição da tarefa:");
                        String descricao = scanner.nextLine();
                        gerenciadorTarefas.adicionarTarefa(descricao);
                        System.out.println("Tarefa adicionada com sucesso!");
                        break;
                    case "2":
                        System.out.println("Digite o ID da tarefa a ser removida:");
                        int id = scanner.nextInt();
                        gerenciadorTarefas.removerTarefa(id);
                        System.out.println("Tarefa removida com sucesso!");
                        break;
                    case "3":
                        System.out.println("Listagem de Tarefas:");
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
