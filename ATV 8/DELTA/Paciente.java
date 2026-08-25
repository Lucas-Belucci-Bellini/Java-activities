package DELTA;

public class Paciente {

    private String nome;
    private int idade;
    private String CPF;

    public Paciente(String nome, int idade, String CPF) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do paciente não pode ficar vazio.");
        }

        if (idade <= 0) {
            throw new IllegalArgumentException("A idade deve ser maior que zero.");
        }

        if (CPF == null || CPF.trim().isEmpty()) {
            throw new IllegalArgumentException("O CPF deve ser informado.");
        }

        this.nome = nome;
        this.idade = idade;
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do paciente não pode ficar vazio.");
        }

        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {

        if (idade <= 0) {
            throw new IllegalArgumentException("A idade deve ser maior que zero.");
        }

        this.idade = idade;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {

        if (CPF == null || CPF.trim().isEmpty()) {
            throw new IllegalArgumentException("O CPF deve ser informado.");
        }

        this.CPF = CPF;
    }

    public void apresentarPaciente() {
        System.out.println("=== DADOS DO PACIENTE ===");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("CPF: " + CPF);
    }

    public void realizarConsulta(Medico medico) {

        System.out.println("=== CONSULTA MÉDICA ===");
        System.out.println(
                "O paciente " + nome +
                " realizou uma consulta com o médico " +
                medico.getNome() +
                ", especialista em " +
                medico.getEspecialidade() +
                "."
        );
    }
}