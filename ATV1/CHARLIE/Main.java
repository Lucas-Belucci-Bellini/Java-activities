package ATV1.CHARLIE;

public class Main {
    public static void main(String[] args) {
        Veiculo tanque = new Veiculo("M1 Abrams", "General Dynamics");
        Veiculo blindado = new Veiculo("MRAP", "Oshkosh");

        System.out.println("--- TESTE DE VEÍCULOS ---");

        tanque.mostrarDados();
        tanque.acelerar(50);
        tanque.mostrarDados();
        tanque.frear(20);
        tanque.frear(40);
        tanque.mostrarDados();

        System.out.println("-------------------------");

        blindado.mostrarDados();
        blindado.acelerar(85);
        blindado.mostrarDados();
        blindado.frear(30);
        blindado.mostrarDados();
    }
}