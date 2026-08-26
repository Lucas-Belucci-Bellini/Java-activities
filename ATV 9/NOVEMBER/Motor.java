package NOVEMBER;

public class Motor {

    private double cilindrada;
    private String combustivel;

    public Motor(double cilindrada, String combustivel) {
        this.cilindrada = cilindrada;
        this.combustivel = combustivel;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public void apresentarMotor() {
        System.out.println("Cilindrada: " + cilindrada + "L");
        System.out.println("Combustível: " + combustivel);
    }
}