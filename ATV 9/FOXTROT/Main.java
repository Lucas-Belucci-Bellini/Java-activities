package FOXTROT;

public class Escola {

    private String nome;
    private String localidade;
    private String tipo;

    private Professor professor;

    public Escola(String nome, String localidade, String tipo, Professor professor) {
        this.nome = nome;
        this.localidade = localidade;
        this.tipo = tipo;
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void apresentarEscola() {
        System.out.println("=== DADOS DA ESCOLA ===");
        System.out.println("Nome: " + nome);
        System.out.println("Localidade: " + localidade);
        System.out.println("Tipo: " + tipo);

        System.out.println();
        professor.apresentarProfessor();
    }
}