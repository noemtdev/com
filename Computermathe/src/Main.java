import Heron.Heron;
import Newton.Newton;
import Falsi.Falsi;
import Bisektion.Bisektion;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Wähle den Algorithmus aus, den du ausführen willst: (Heron; Newton; Falsi; Bisektion)");
        String methode = sc.nextLine();

        if (methode.equals("Bisektion")) {
            System.out.println("Die Form einer quadratischen Funktion ist ist ax²+ bx + c");
            System.out.println("Gebe den Wert von a ein!");
            double a = sc.nextDouble();

            System.out.println("Gebe den Wert von b ein!");
            double b = sc.nextDouble();

            System.out.println("Gebe den Wert von c ein!");
            double c = sc.nextDouble();

            System.out.println("Wie viele Iterationen soll der Algorithmus machen?");
            int iterations = sc.nextInt();

            System.out.println("Gebe einen ersten Anfangswert an!");
            double w1 = sc.nextDouble();

            System.out.println("Gebe einen zweiten Anfangswert an!");
            double w2 = sc.nextDouble();

            Bisektion bisektion = new Bisektion(a, b, c);
            bisektion.bisektion(iterations, w1, w2);
        }

        if (methode.equals("Heron")) {

            System.out.println("Wie viele Iterationen soll der Algorithmus machen?");
            int iterations = sc.nextInt();

            System.out.println("Für welche Zahl soll die Wurzel ausgegeben werden?");
            double zahl = sc.nextDouble();

            System.out.println("Gebe einen Näherungswert an!");
            double naeherung = sc.nextDouble();

            Heron heron = new Heron();
            System.out.println("Entgültiger Näherungswert: " + heron.heron(iterations, naeherung, zahl));
        }

        if (methode.equals("Newton")) {
            System.out.println("Die Form des Polynoms ist ist ax⁵ + bx⁴ + cx³ + dx² + ex + f");
            // dies wurde nicht getestet aber es sollte funktionieren (wieso sollte es nicht funktionieren)
            
            System.out.println("Gebe den Wert von a ein!");
            double a = sc.nextDouble();

            System.out.println("Gebe den Wert von b ein!");
            double b = sc.nextDouble();

            System.out.println("Gebe den Wert von c ein!");
            double c = sc.nextDouble();

            System.out.println("Gebe einen Wert von d ein!");
            double d = sc.nextDouble();

            System.out.println("Gebe einen Wert von e ein!");
            double e = sc.nextDouble();

            System.out.println("Gebe einen Wert von f ein!");
            double f = sc.nextDouble();

            System.out.println("Wie viele Iterationen soll der Algorithmus machen?");
            int iterations = sc.nextInt();

            System.out.println("Gebe einen Näherungswert an!");
            double naeherung = sc.nextDouble();

            Newton newton = new Newton(a, b, c, d, e, f);
            System.out.println("Entgültiger Näherungswert: " + newton.newton(iterations, naeherung));
        }

        if (methode.equals("Falsi")) {
            System.out.println("Die Form einer quadratischen Funktion ist ist ax²+ bx + c");
            System.out.println("Gebe den Wert von a ein!");
            double a = sc.nextDouble();

            System.out.println("Gebe den Wert von b ein!");
            double b = sc.nextDouble();

            System.out.println("Gebe den Wert von c ein!");
            double c = sc.nextDouble();

            System.out.println("Wie viele Iterationen soll der Algorithmus machen?");
            int iterations = sc.nextInt();

            System.out.println("Gebe einen Näherungswert an!");
            double naeherung = sc.nextDouble();

            Falsi falsi = new Falsi(a, b, c);
            System.out.println("Entgültiger Näherungswert: " + falsi.falsi(iterations, naeherung));


        }
        System.out.println(" ");


    }

}
