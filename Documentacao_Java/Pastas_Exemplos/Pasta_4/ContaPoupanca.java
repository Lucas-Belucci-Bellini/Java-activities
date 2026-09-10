public class ContaPoupanca extends ContaBancaria {
    private double taxa;

    public ContaPoupanca(String titular, double saldo, double taxa) {
        super(titular, saldo);
        this.taxa = taxa;
    }

    public void render() {
        double novoSaldo = getSaldo() + (getSaldo() * taxa / 100);
        System.out.println("Saldo atual após rendimento: R$ " + novoSaldo);
    }
}
