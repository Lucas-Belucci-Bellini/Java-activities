package BRAVO;

import java.util.Scanner;

class Triangulo {
    public double A;
    public double B;
    public double C;

    public double calcularArea() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com o lado A:");
        A = sc.nextDouble();

        System.out.println("Entre com o lado B:");
        B = sc.nextDouble();

        System.out.println("Entre com o lado C:");
        C = sc.nextDouble();

        double p = (A + B + C) / 2.0;
        return Math.sqrt(p * (p - A) * (p - B) * (p - C));
    }
}
