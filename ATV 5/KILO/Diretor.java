package KILO;

public class Diretor extends Funcionario {

    private String area;
    private int anosGestao;

    public Diretor(
            String nome,
            int idade,
            String cpf,
            double salario,
            String setor,
            String matricula,
            String area,
            int anosGestao) {

        super(nome, idade, cpf, salario, setor, matricula);

        this.area = area;
        this.anosGestao = anosGestao;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getAnosGestao() {
        return anosGestao;
    }

    public void setAnosGestao(int anosGestao) {
        this.anosGestao = anosGestao;
    }

    @Override
    public void apresentarDados() {
        super.apresentarDados();

        System.out.println("Área: " + area);
        System.out.println("Anos de gestão: " + anosGestao);
    }
}