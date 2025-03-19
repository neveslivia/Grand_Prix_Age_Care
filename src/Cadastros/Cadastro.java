package Cadastros;

import java.util.Random;

public class Cadastro {
    protected String nome;
    protected String dataNascimento;
    protected String cpf;
    protected String endereco;
    protected String telefone;
    protected String email;
    protected String senha;
    protected int id;

    public Cadastro(String nome, String dataNascimento, String cpf, String endereco, String telefone, String email, String senha) {
        this.id = new Random().nextInt(100000);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void exibirDados() {
        System.out.println ("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("CPF: " + cpf);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
    }


}
