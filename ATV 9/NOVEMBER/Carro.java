package NOVEMBER;

public class Carro {

    private String marca;
    private String modelo;

    private Motor motor;

    public Carro(String marca, String modelo, double cilindrada, String combustivel) {
        this.marca = marca;
        this.modelo = modelo;

        this.motor = new Motor(cilindrada, combustivel);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Motor getMotor() {
        return motor;
    }

    public void apresentarCarro() {
        System.out.println("=== DADOS DO CARRO ===");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);

        System.out.println();
        System.out.println("=== DADOS DO MOTOR ===");
        motor.apresentarMotor();
    }
}