# projetofinal_sdso8a

# Gerenciador de Tarefas

O Gerenciador de Tarefas é um projeto Java que consiste em um sistema de gerenciamento de tarefas, onde é possível adicionar, remover e listar tarefas. O projeto utiliza duas tecnologias diferentes para disponibilizar os serviços: RMI (Remote Method Invocation) e Web Services.

## Funcionalidades

O projeto possui as seguintes funcionalidades:

- Adicionar uma nova tarefa: Permite adicionar uma nova tarefa ao sistema, informando a descrição da tarefa e, opcionalmente, a data de conclusão da tarefa.
- Remover uma tarefa: Permite remover uma tarefa do sistema, informando o ID da tarefa a ser removida.
- Listar tarefas: Exibe a lista de todas as tarefas cadastradas no sistema, mostrando a descrição e, quando disponível, a data de conclusão da tarefa.

## Tecnologias utilizadas

O projeto utiliza as seguintes tecnologias:

- Java: Linguagem de programação utilizada para implementar o sistema.
- RMI (Remote Method Invocation): Tecnologia do Java que permite a invocação de métodos de objetos remotos.
- Web Services: Utiliza a API JAX-WS para criar um serviço web SOAP.

## Estrutura do projeto

O projeto está dividido em várias classes, cada uma com sua responsabilidade específica. A seguir, uma breve descrição de cada classe:

- `Servidor`: Classe responsável por iniciar o servidor RMI e publicar o serviço web. Configura o RMI para que o `GerenciadorTarefasImpl` seja disponibilizado remotamente.
- `Cliente`: Classe responsável por interagir com o usuário, exibindo um menu e enviando requisições para o servidor.
- `GerenciadorTarefas`: Interface remota RMI que define os métodos que podem ser invocados remotamente pelo cliente.
- `GerenciadorTarefasImpl`: Implementação da interface `GerenciadorTarefas`. Essa classe contém a lógica para adicionar, remover e listar tarefas.
- `GerenciadorTarefasWebService`: Interface do serviço web SOAP que define os métodos disponíveis para os clientes.
- `GerenciadorTarefasResource`: Implementação do serviço web SOAP. Essa classe contém a lógica para adicionar, remover e listar tarefas utilizando o protocolo SOAP.
- `Tarefa`: Classe que representa uma tarefa, contendo a descrição e, opcionalmente, a data de conclusão.

## Executando o projeto

Para executar o projeto, siga as instruções abaixo:

1. Compile todas as classes do projeto.
2. Execute a classe `Servidor` para iniciar o servidor RMI e publicar o serviço web.
3. Execute a classe `Cliente` para iniciar o cliente e interagir com o sistema de gerenciamento de tarefas.

Certifique-se de que o servidor RMI esteja em execução antes de executar o cliente.

## Observações

- O servidor RMI utiliza a porta 1099 para registrar o serviço.
- O serviço web SOAP é publicado no endereço `http://localhost:8080/gerenciadortarefas`.
- O cliente exibe um menu com opções numeradas de 1 a 4. Para selecionar uma opção, digite o número correspondente e pressione Enter.
- Para adicionar uma tarefa com data, utilize o formato "dd/MM/yyyy" ao informar a

 data da tarefa.
- O projeto utiliza as bibliotecas `javax.jws`, `javax.ws.rs` e `javax.xml.bind` para suportar os serviços web SOAP e RESTful.
- Certifique-se de que todas as dependências estejam corretamente configuradas em seu ambiente de desenvolvimento.

## Conclusão

O projeto Gerenciador de Tarefas demonstra a utilização de tecnologias como RMI e Web Services para implementar um sistema de gerenciamento de tarefas. Com essa aplicação, é possível adicionar, remover e listar tarefas de forma remota, utilizando diferentes protocolos de comunicação.

Esse README fornece uma visão geral do projeto e explica como executá-lo. Caso seja necessário, consulte a documentação das bibliotecas utilizadas para obter mais informações sobre as funcionalidades específicas implementadas no projeto.
