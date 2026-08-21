package ALFA;

public class Vendedor extends Funcionario {

    private double valorVendas;
    private double percentualComissao;

    public Vendedor(
            String nome,
            int matricula,
            double salarioBase,
            double valorVendas,
            double percentualComissao) {

        super(nome, matricula, salarioBase);

        if (valorVendas < 0) {
            throw new IllegalArgumentException(
                    "O valor das vendas não pode ser negativo."
            );
        }

        if (percentualComissao < 0 || percentualComissao > 100) {
            throw new IllegalArgumentException(
                    "O percentual de comissão deve estar entre 0 e 100."
            );
        }

        this.valorVendas = valorVendas;
        this.percentualComissao = percentualComissao;
    }

    public double getValorVendas() {
        return valorVendas;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setValorVendas(double valorVendas) {

        if (valorVendas < 0) {
            throw new IllegalArgumentException(
                    "O valor das vendas não pode ser negativo."
            );
        }

        this.valorVendas = valorVendas;
    }

    public void setPercentualComissao(double percentualComissao) {

        if (percentualComissao < 0 || percentualComissao > 100) {
            throw new IllegalArgumentException(
                    "O percentual de comissão deve estar entre 0 e 100."
            );
        }

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
        System.out.printf("Percentual de comissão: %.2f%%%n",
                percentualComissao);
    }
}