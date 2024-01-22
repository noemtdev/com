package Newton;
public class Newton {
    static double a;
    static double b;
    static double c;
    static double d;
    static double e;
    static double f;
    // x^5 + x^4 + x^3 + x^2 + x + 1
    public Newton(double a, double b, double c, double d, double e, double f) {
        Newton.a = a;
        Newton.b = b;
        Newton.c = c;
        Newton.d = d;
        Newton.e = e;
        Newton.f = f;
    }

    public static double funktionswert(double x) {
        return a*Math.pow(x, 5) + b*Math.pow(x, 4) + c*Math.pow(x, 3) + d*Math.pow(x, 2) + e*x + f;
    }

    public static double ableitungswert(double x) {
        return 5*a*Math.pow(x, 4) + 4*b*Math.pow(x, 3) + 3*c*Math.pow(x, 2) + 2*d*x + e;
    }
    public static double newton(int iterationen, double naeherungswert) {
        for (int i = 0; i < iterationen; i++) {
            naeherungswert = naeherungswert-(funktionswert(naeherungswert)/(ableitungswert(naeherungswert)));
            System.out.println(naeherungswert);
        }
        return naeherungswert;
    }
}
