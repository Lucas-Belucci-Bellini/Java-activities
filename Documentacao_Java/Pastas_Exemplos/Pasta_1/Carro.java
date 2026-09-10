public class Carro {
    private String modelo;
    private int ano;

    public Carro(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    public void acelerar() {
        System.out.println("O " + modelo + " está acelerando.");
    }
}
