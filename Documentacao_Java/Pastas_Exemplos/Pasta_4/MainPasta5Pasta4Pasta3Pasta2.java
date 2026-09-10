public class MainPasta4 {
    public static void main(String[] args) {
        ContaPoupanca conta = new ContaPoupanca("Lucas", 1000.0, 1.5);
        conta.depositar(200.0);
        conta.render();
    }
}
