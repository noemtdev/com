package Falsi;
public class Falsi {
    static double a;
    static double b;
    static double c;

    public Falsi(double a, double b, double c) {
        Falsi.a = a;
        Falsi.b = b;
        Falsi.c = c;
    }

    public static double funktionswert(double x) {
        return a*x*x + b*x + c;
    }

    public static double falsi(int iterationen, double naeherungswert) {
        for (int i = 0; i < iterationen; i++) {
            naeherungswert = naeherungswert-funktionswert(naeherungswert)*((1-naeherungswert)/(funktionswert(1)-funktionswert(naeherungswert)));
            System.out.println(naeherungswert);
        }
        return naeherungswert;
    }
}
