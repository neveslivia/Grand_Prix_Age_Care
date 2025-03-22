package BancoDeDadosProfisisonais;


import Cadastros.CadastroCliente;
import Cadastros.CadastroProfissional;
import java.util.ArrayList;
import java.util.List;


public class BancoDadosProfissionais {
    private List<CadastroProfissional> profissionais;

    public BancoDadosProfissionais() {
        this.profissionais = new ArrayList<>();
    }

    public void adicionarProfissional(CadastroProfissional profissional) {
        profissionais.add(profissional);
        System.out.println("Profissional adicionado com sucesso: " + profissional.getNome());
    }


    public CadastroProfissional buscarProfissionalPorId(String id) {  // esperando String como ID
        for (CadastroProfissional profissional : profissionais) {
            if (profissional.getId().equals(id)) {  // comparando String corretamente
                return profissional;
            }
        }
        return null;
    }


    public void listarTodosProfissionais() {
        if (profissionais.isEmpty()) {
            System.out.println("Nenhum profissional cadastrado.");
        } else {
            for (CadastroProfissional profissional : profissionais) {
                profissional.exibirPerfil();
                System.out.println("----------------------");
            }
        }
    }


}
