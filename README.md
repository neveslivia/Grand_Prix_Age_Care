package Agendamento_reservas;

import Cadastros.CadastroCliente;
import Cadastros.CadastroProfissional;

public class Agendamento {
    private int id;
    private String data;
    private CadastroProfissional cuidador;  // Mudamos para CadastroProfissional
    private CadastroCliente paciente;  // Referência ao paciente fixo

    // Construtor para o agendamento
    public Agendamento(int id, String data, CadastroProfissional cuidador, CadastroCliente paciente) {
        this.id = id;
        this.data = data;
        this.cuidador = cuidador;
        this.paciente = paciente;
    }

    // Getters para acessar os dados
    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public CadastroProfissional getCuidador() {
        return cuidador;
    }

    public CadastroCliente getPaciente() {
        return paciente;
    }
}

------------------------------------------------------------------
package Agendamento_reservas;

import Agendamento_reservas.Agendamento;
import BancoDeDadosProfisisonais.BancoDadosProfissionais;
import Cadastros.CadastroCliente;
import Cadastros.CadastroProfissional;

import java.util.ArrayList;
import java.util.List;

public class AgendamentoService {
    private BancoDadosProfissionais bancoDadosProfissionais;  // Banco de profissionais (cuidadores)
    private CadastroCliente pacienteFixo;  // Referência ao paciente fixo
    private List<Agendamento> agendamentos = new ArrayList<>();
    private int idAgendamento = 1;

    // Construtor que recebe o BancoDadosProfissionais
    public AgendamentoService(BancoDadosProfissionais bancoDadosProfissionais) {
        this.bancoDadosProfissionais = bancoDadosProfissionais;
    }

    // Método para agendar atendimento
    public void agendarAtendimento(String data, int cuidadorId) {
        // Busca o profissional (cuidador) pelo ID no banco de dados
        CadastroProfissional profissional = bancoDadosProfissionais.buscarProfissionalPorId(cuidadorId);

        if (profissional == null) {
            System.out.println("❌ ERRO: Cuidador não encontrado!");
            return;
        }

        // Criação do agendamento
        Agendamento agendamento = new Agendamento(idAgendamento++, data, profissional, pacienteFixo);
        agendamentos.add(agendamento);
        System.out.println("✅ Atendimento agendado com sucesso!");
    }

    // Método para listar os agendamentos
    public void listarAgendamentos() {
        if (agendamentos.isEmpty()) {
            System.out.println("Nenhum agendamento encontrado.");
            return;
        }

        for (Agendamento agendamento : agendamentos) {
            // Exibe o nome do paciente e do cuidador usando os métodos correspondentes
            String nomePaciente = (agendamento.getPaciente() != null) ? agendamento.getPaciente().getNome() : "Paciente não definido";
            String nomeCuidador = (agendamento.getCuidador() != null) ? agendamento.getCuidador().getNome() : "Cuidador não definido";

            System.out.println("ID: " + agendamento.getId() +
                    ", Data: " + agendamento.getData() +
                    ", Cuidador: " + nomeCuidador +
                    ", Paciente: " + nomePaciente);
        }
    }
}
---------------------------------------------------------------------------
package Agendamento_reservas;

import java.util.Scanner;
import java.util.List;
import BancoDeDadosProfisisonais.BancoDadosProfissionais;
import Cadastros.CadastroProfissional;

public class SistemaAgendamento {
    private final Scanner scanner;
    private final AgendamentoService agendamentoService;
    private final BancoDadosProfissionais bancoProfissionais;

    public SistemaAgendamento(BancoDadosProfissionais bancoProfissionais) {
        this.scanner = new Scanner(System.in);
        this.agendamentoService = new AgendamentoService(bancoProfissionais);
        this.bancoProfissionais = bancoProfissionais;
    }

    public void iniciar() {
        while (true) {
            System.out.println("\n1. Agendar Atendimento\n2. Listar Agendamentos\n3. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Data do atendimento (YYYY-MM-DD): ");
                    String data = scanner.nextLine();

                    List<CadastroProfissional> profissionais = bancoProfissionais.getProfissionais();
                    if (profissionais.isEmpty()) {
                        System.out.println("Nenhum profissional cadastrado.");
                        break;
                    }

                    System.out.println("Escolha o profissional:");
                    for (int i = 0; i < profissionais.size(); i++) {
                        System.out.println((i + 1) + " - " + profissionais.get(i).getNome());
                    }

                    int escolha = scanner.nextInt();
                    scanner.nextLine();

                    if (escolha < 1 || escolha > profissionais.size()) {
                        System.out.println("Opção inválida!");
                        break;
                    }

                    CadastroProfissional profissionalSelecionado = profissionais.get(escolha - 1);
                    agendamentoService.agendarAtendimento(data, profissionalSelecionado.getId());
                    break;

                case 2:
                    agendamentoService.listarAgendamentos();
                    break;

                case 3:
                    System.out.println("Saindo...");
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
