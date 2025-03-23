package Program;

import Entities.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Program {
        public static void main(String[] args) {
            // Criando um scanner para leitura de entradas do usuário
            Scanner scanner = new Scanner(System.in);

            // Coletando dados para o cadastro
            System.out.println("Digite o e-mail:");
            String email = scanner.nextLine();

            System.out.println("Digite a senha:");
            String senha = scanner.nextLine();

            // Criando o objeto Cadastro com os dados fornecidos
            Cadastro cadastro = new Cadastro(email, senha);

            // Coletando o título e a descrição do chamado
            System.out.println("\nDigite o título do chamado:");
            String titulo = scanner.nextLine();

            System.out.println("Digite a descrição do chamado:");
            String descricao = scanner.nextLine();

            // Coletando o status do chamado
            System.out.println("\nSelecione o status do chamado (1 - ABERTO, 2 - EM_ANDAMENTO, 3 - REALIZADO):");
            int statusChoice = scanner.nextInt();
            Status_Chamado status = Status_Chamado.ABERTO; // valor padrão
            switch (statusChoice) {
                case 1:
                    status = Status_Chamado.ABERTO;
                    break;
                case 2:
                    status = Status_Chamado.EM_ANDAMENTO;
                    break;
                case 3:
                    status = Status_Chamado.REALIZADO;
                    break;
                default:
                    System.out.println("Opção inválida! Status será considerado como ABERTO.");
            }

            // Coletando a prioridade do chamado
            System.out.println("\nSelecione a prioridade do chamado (1 - BAIXA, 2 - MEDIA, 3 - ALTA):");
            int prioridadeChoice = scanner.nextInt();
            Prioridade_Chamado prioridade = Prioridade_Chamado.BAIXA; // valor padrão
            switch (prioridadeChoice) {
                case 1:
                    prioridade = Prioridade_Chamado.BAIXA;
                    break;
                case 2:
                    prioridade = Prioridade_Chamado.MEDIA;
                    break;
                case 3:
                    prioridade = Prioridade_Chamado.ALTA;
                    break;
                default:
                    System.out.println("Opção inválida! Prioridade será considerada como BAIXA.");
            }

            // Gerando a data de solicitação automaticamente (data atual)
            LocalDateTime dataSolicitacao = LocalDateTime.now();

            // Gerando a data de conclusão automaticamente (2 dias após a solicitação)
            LocalDateTime dataConclusao = dataSolicitacao.plusDays(2);

            // Criando o chamado de suporte
            Chamado_Suporte chamado = new Chamado_Suporte(
                    cadastro,
                    titulo,
                    descricao,
                    status,
                    prioridade,
                    dataSolicitacao,
                    dataConclusao
            );

            // Exibindo os detalhes do chamado
            System.out.println("\nDetalhes do Chamado:");
            System.out.println("ID do Chamado: " + chamado.getIdChamado());
            System.out.println("Título: " + chamado.getTitulo());
            System.out.println("Descrição: " + chamado.getDescricao());
            System.out.println("Status: " + chamado.getStatus());
            System.out.println("Prioridade: " + chamado.getPrioridadeChamado());
            System.out.println("Data da Solicitação: " + dataSolicitacao.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            System.out.println("Data da Conclusão: " + dataConclusao.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

            // Testando a geração de resposta para perguntas frequentes
            scanner.nextLine(); // Consumir o newline deixado pelo nextInt
            System.out.println("\nDigite uma pergunta frequente:");
            String pergunta = scanner.nextLine();
            String resposta = chamado.gerarResposta(pergunta);
            System.out.println("\nResposta para a pergunta: " + pergunta);
            System.out.println(resposta);

            // Fechar o scanner
            scanner.close();
        }


}




