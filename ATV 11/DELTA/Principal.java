public class Principal {

    public static void main(String[] args) {
        Forma[] formas = {
            new Retangulo("Retangulo", 5.0, 3.0),
            new Circulo("Circulo", 2.0)
        };

        for (Forma forma : formas) {
            forma.apresentarDados();
            System.out.println();
        }
    }
}
