package GOLF.ContaPoupanca;

import GOLF.ContaBancaria.ContaBancaria;

public class ContaPoupanca extends ContaBancaria {

    private double taxaRendimento;

    public ContaPoupanca(
            String titular,
            String numeroConta,
            double saldo,
            String nomeBanco,
            double taxaRendimento) {

        super(titular, numeroConta, saldo, nomeBanco);

        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public void apresentarConta() {

        System.out.println("=== CONTA POUPANÇA ===");
        System.out.println("Titular: " + getTitular());
        System.out.println("Número da conta: " + getNumeroConta());
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("Banco: " + nomeBanco);
        System.out.println("Taxa de rendimento: " + taxaRendimento + "%");
    }
}