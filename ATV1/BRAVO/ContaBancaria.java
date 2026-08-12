package ATV1.BRAVO;

public class ContaBancaria {
    String titular;
    String numeroDaConta;
    double saldo;

    public ContaBancaria(String titular, String numeroDaConta, double saldoInicial) {
        this.titular = titular;
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depositado R$ %.2f na conta de %s.%n", valor, titular);
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.printf("Saque de R$ %.2f realizado com sucesso por %s.%n", valor, titular);
        } else {
            System.out.printf("SAQUE NEGADO: %s tentou sacar R$ %.2f, mas o saldo é insuficiente.%n", titular, valor);
        }
    }

    public void mostrarSaldo() {
        System.out.printf("Titular: %s | Conta: %s | Saldo Atual: R$ %.2f%n",
                titular, numeroDaConta, saldo);
    }
}