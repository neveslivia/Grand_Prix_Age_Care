package Cadastros;


import BancoDeDadosProfisisonais.BancoDadosProfissionais;


public class Program {
    public static void main(String[] args) {
        // Criando instância do banco de dados
        BancoDadosProfissionais banco = new BancoDadosProfissionais();


        // Criando profissionais
        CadastroProfissional profissional1 = new CadastroProfissional(
                "Dr. João Silva", "15/04/1980", "12345678900", "Rua A, 123",
                "11987654321", "joao@email.com", "senha123",
                "CRM-12345", "Geriatria", 15, "DISPONIVEL", 200.0
        );


        CadastroProfissional profissional2 = new CadastroProfissional(
                "Dra. Ana Costa", "10/11/1975", "55566677788", "Rua C, 789",
                "11955554444", "ana@email.com", "senha456",
                "CRM-67890", "Fisioterapia", 20, "INDISPONIVEL", 180.0
        );


        // Adicionando ao banco de dados
        banco.adicionarProfissional(profissional1);
        banco.adicionarProfissional(profissional2);

        //criando clientes e passando atributo por parãmetro pro construtor
        CadastroCliente cliente1 = new CadastroCliente("Roberto Almeida", "22/10/1950","99753267895",
                "Rua Flor, 77","587961125523","roberto@email.com","roberto123","Luiza Almeida"
        );
        //criando clientes e passando atributo por parãmetro pro construtor
        CadastroCliente cliente2 = new CadastroCliente("Joana Oliveira", "12/01/1960","92478563289",
                "Rua Alegria","25318796845","Joana@email.com","Joana902","Karla"
        );


        // Listando todos os profissionais cadastrados
        System.out.println("\n=== LISTA DE TODOS OS PROFISSIONAIS ===");
        banco.listarTodosProfissionais();


        // Testando busca de um profissional pelo ID
        System.out.println("\n=== BUSCANDO PROFISSIONAL PELO ID ===");
        CadastroProfissional encontrado = banco.buscarProfissionalPorId(profissional1.getId());  // Correção: Chamada correta de getId()
        if (encontrado != null) {
            encontrado.exibirPerfil();
        } else {
            System.out.println("Profissional não encontrado!");
        }


        // Testando busca de um ID inexistente
        System.out.println("\n=== TESTANDO BUSCA COM ID INEXISTENTE ===");
        CadastroProfissional inexistente = banco.buscarProfissionalPorId("99999999");  // ID inexistente
        if (inexistente == null) {
            System.out.println("Nenhum profissional encontrado com esse ID.");
        }
    }
}
