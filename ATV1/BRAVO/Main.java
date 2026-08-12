package ATV1.BRAVO;

public class Main{
   public static void main(String[] args) {
      ContaBancaria contaRenan = new ContaBancaria("Renan Santos", "1010-X", 1000.00);
      ContaBancaria contaKim = new ContaBancaria("Kim Kataguiri", "2020-Y", 1500.00);

      System.out.println("--- MOVIMENTAÇÕES BANCÁRIAS ---");

      contaRenan.mostrarSaldo();
      contaRenan.depositar(500.00);
      contaRenan.sacar(200.00);
      contaRenan.sacar(2000.00);
      contaRenan.mostrarSaldo();

      System.out.println("--------------------------------");

      contaKim.mostrarSaldo();
      contaKim.sacar(300.00);
      contaKim.mostrarSaldo();
   }
}