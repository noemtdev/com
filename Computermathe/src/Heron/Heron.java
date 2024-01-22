package Heron;

public class Heron {
    public static double heron(int iterationen, double naeherungswert, double zahl) {
        for (int i = 0; i < iterationen; i++) {
            naeherungswert = 0.5*(naeherungswert+(zahl/naeherungswert));
            System.out.println(naeherungswert);
        }
        return naeherungswert;
    }
}