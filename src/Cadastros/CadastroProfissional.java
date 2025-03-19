package Cadastros;

class CadastroProfissional extends Cadastro {
    protected String registroProfissional;
    protected  String especialidade;
    protected  int experiencia;
    protected  String disponibilidade;
    protected  Double valorHora;

    public CadastroProfissional(String nome, String dataNascimento, String cpf, String endereco, String telefone, String email, String senha,
                                String registroProfissional, String especialidade, int experiencia, String disponibilidade, double valorHora) {
        super(nome, dataNascimento, cpf, endereco, telefone, email, senha);
        this.registroProfissional = registroProfissional;
        this.especialidade = especialidade;
        this.experiencia = experiencia;
        this.disponibilidade = disponibilidade;
        this.valorHora = valorHora;
    }
    
}
