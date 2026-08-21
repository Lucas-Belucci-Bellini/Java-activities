package ALFA;

public class Vendedor extends Funcionario {

    private double valorVendas;
    private double percentualComissao;

    public Vendedor(String nome, int matricula, double salarioBase,
                    double valorVendas, double percentualComissao) {

        super(nome, matricula, salarioBase);

        this.valorVendas = valorVendas;
        this.percentualComissao = percentualComissao;
    }

    public double getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(double valorVendas) {
        this.valorVendas = valorVendas;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    @Override
    public double calcularSalario() {
        double comissao = valorVendas * percentualComissao / 100;
        return getSalarioBase() + comissao;
    }

    public void registrarVenda() {
        System.out.println("O vendedor registrou uma venda.");
    }

    @Override
    public void apresentarDados() {
        super.apresentarDados();
        System.out.printf("Valor das vendas: R$ %.2f%n", valorVendas);
        System.out.printf("Percentual de comissão: %.2f%%%n", percentualComissao);
    }
}