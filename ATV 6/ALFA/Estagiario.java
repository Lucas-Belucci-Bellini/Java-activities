package ALFA;

public class Estagiario extends Funcionario {

    private String instituicaoEnsino;

    public Estagiario(
            String nome,
            int matricula,
            double salarioBase,
            String instituicaoEnsino) {

        super(nome, matricula, salarioBase);

        if (instituicaoEnsino == null ||
                instituicaoEnsino.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "O nome da instituição de ensino não pode ficar vazio."
            );
        }

        this.instituicaoEnsino = instituicaoEnsino;
    }

    public String getInstituicaoEnsino() {
        return instituicaoEnsino;
    }

    public void setInstituicaoEnsino(String instituicaoEnsino) {

        if (instituicaoEnsino == null ||
                instituicaoEnsino.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "O nome da instituição de ensino não pode ficar vazio."
            );
        }

        this.instituicaoEnsino = instituicaoEnsino;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase();
    }

    public void realizarTreinamento() {
        System.out.println("O estagiário está realizando um treinamento.");
    }

    @Override
    public void apresentarDados() {
        super.apresentarDados();

        System.out.println(
                "Instituição de ensino: " + instituicaoEnsino
        );
    }
}