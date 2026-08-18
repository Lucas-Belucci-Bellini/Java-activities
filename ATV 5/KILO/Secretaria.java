package KILO;

public class Secretaria extends Funcionario {

    private String turno;
    private String ramal;

    public Secretaria(
            String nome,
            int idade,
            String cpf,
            double salario,
            String setor,
            String matricula,
            String turno,
            String ramal) {

        super(nome, idade, cpf, salario, setor, matricula);

        this.turno = turno;
        this.ramal = ramal;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    @Override
    public void apresentarDados() {
        super.apresentarDados();

        System.out.println("Turno: " + turno);
        System.out.println("Ramal: " + ramal);
    }
}