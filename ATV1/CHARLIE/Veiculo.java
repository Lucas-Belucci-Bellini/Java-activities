package ATV1.CHARLIE;

public class Veiculo {
    String modelo;
    String marca;
    int velocidadeAtual;

    public Veiculo(String modelo, String marca) {
        this.modelo = modelo;
        this.marca = marca;
        this.velocidadeAtual = 0;
    }

    public void acelerar(int valor) {
        if (valor > 0) {
            velocidadeAtual += valor;
            System.out.println(modelo + " acelerou. Velocidade aumentou em " + valor + " km/h.");
        }
    }

    public void frear(int valor) {
        if (valor > 0) {
            velocidadeAtual -= valor;
            if (velocidadeAtual < 0) {
                velocidadeAtual = 0;
            }
            System.out.println(modelo + " freou. Velocidade reduziu em " + valor + " km/h.");
        }
    }

    public void mostrarDados() {
        System.out.printf("Veículo: %s %s | Velocidade Atual: %d km/h%n",
                marca, modelo, velocidadeAtual);
    }
}