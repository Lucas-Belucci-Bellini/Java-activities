package DELTA;

public class Medico {

    private String nome;
    private String especialidade;
    private String CRM;

    public Medico(String nome, String especialidade, String CRM) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do médico não pode ficar vazio.");
        }

        if (especialidade == null || especialidade.trim().isEmpty()) {
            throw new IllegalArgumentException("A especialidade deve ser informada.");
        }

        if (CRM == null || CRM.trim().isEmpty()) {
            throw new IllegalArgumentException("O CRM não pode ficar vazio.");
        }

        this.nome = nome;
        this.especialidade = especialidade;
        this.CRM = CRM;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do médico não pode ficar vazio.");
        }

        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {

        if (especialidade == null || especialidade.trim().isEmpty()) {
            throw new IllegalArgumentException("A especialidade deve ser informada.");
        }

        this.especialidade = especialidade;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {

        if (CRM == null || CRM.trim().isEmpty()) {
            throw new IllegalArgumentException("O CRM não pode ficar vazio.");
        }

        this.CRM = CRM;
    }

    public void apresentarMedico() {
        System.out.println("=== DADOS DO MÉDICO ===");
        System.out.println("Nome: " + nome);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("CRM: " + CRM);
    }
}