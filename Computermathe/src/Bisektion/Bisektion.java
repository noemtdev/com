package Bisektion;
public class Bisektion {
    static double a;
    static double b;
    static double c;

    public Bisektion(double a, double b, double c) {
        Bisektion.a = a;
        Bisektion.b = b;
        Bisektion.c = c;
    }

    public static double funktionswert(double x) {
        return a * x * x + b * x + c;
    }

    public static void bisektion(int iterationen, double anfangswert_min, double anfangswert_max) {
        if (funktionswert(anfangswert_max) * funktionswert(anfangswert_min) < 0) {
            if (anfangswert_min > anfangswert_max) {
                double temp = anfangswert_min;
                anfangswert_min = anfangswert_max;
                anfangswert_max = temp;
            }

            double mittelwert;



            for (int i = 0; i < iterationen; i++) {
                mittelwert = (anfangswert_min + anfangswert_max) / 2;
                System.out.println(anfangswert_min + " " + anfangswert_max + " " + mittelwert);


                if (funktionswert(mittelwert) == 0) {
                    break;
                }

                if (funktionswert(anfangswert_min)*funktionswert(mittelwert) < 0) {
                    anfangswert_max = mittelwert;
                }
                else {
                    anfangswert_min = mittelwert;
                }
            }
        }
    }

}
