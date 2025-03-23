package BancoDeDadosProfisisonais;

import Cadastros.CadastroProfissional;
import java.util.ArrayList;
import java.util.List;

public class BancoDadosProfissionais {
    private final List<CadastroProfissional> profissionais;

    public BancoDadosProfissionais() {
        this.profissionais = new ArrayList<>();
    }

    public void adicionarProfissional(CadastroProfissional profissional) {
        profissionais.add(profissional);
        System.out.println("Profissional adicionado com sucesso: " + profissional.getNome());
    }

    public CadastroProfissional buscarProfissionalPorId(int id) {
        for (CadastroProfissional profissional : profissionais) {
            if (profissional.getId() == id) {
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
