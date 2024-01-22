import javax.swing.*;
import java.awt.*;


class Bisektion {
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

    public static String bisektion(int iterationen, double anfangswert_min, double anfangswert_max) {
        if (funktionswert(anfangswert_max) * funktionswert(anfangswert_min) < 0) {
            if (anfangswert_min > anfangswert_max) {
                double temp = anfangswert_min;
                anfangswert_min = anfangswert_max;
                anfangswert_max = temp;
            }

            double mittelwert;
            StringBuilder returnValue = new StringBuilder();

            for (int i = 0; i < iterationen; i++) {
                mittelwert = (anfangswert_min + anfangswert_max) / 2;
                returnValue
                        .append(anfangswert_min).append(" ")
                        .append(anfangswert_max).append(" ")
                        .append(mittelwert).append("\n");


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
            return returnValue.toString();
        }
        else {
            return "Der Funktionswert liegt außerhalb der angegeben Werte.";
        }
    }

}
public class BisektionFrame extends JFrame {

    private final JTextField eingabe1;
    private final JTextField eingabe2;
    private final JTextField eingabe3;
    private final JTextField eingabe4;
    private final JTextField eingabe5;
    private final JTextField eingabe6;

    public BisektionFrame() {
        super("Bisektion-Verfahren");

        JPanel mainPanel = new JPanel();
        JPanel inputPanel = new JPanel();

        setLayout(new BorderLayout());
        setLocationRelativeTo(null);


        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Die Form einer quadratischen Funktion ist ist ax²+ bx + c");
        inputPanel.add(titleLabel);

        JLabel eingabe1Label = new JLabel("a:");
        inputPanel.add(eingabe1Label);
        eingabe1 = new JTextField(20);
        inputPanel.add(eingabe1);

        JLabel eingabe2Label = new JLabel("b:");
        inputPanel.add(eingabe2Label);
        eingabe2 = new JTextField(20);
        inputPanel.add(eingabe2);

        JLabel eingabe3Label = new JLabel("c:");
        inputPanel.add(eingabe3Label);
        eingabe3 = new JTextField(20);
        inputPanel.add(eingabe3);

        JLabel eingabe4Label = new JLabel("Zahl der Iterationen");
        inputPanel.add(eingabe4Label);
        eingabe4 = new JTextField(20);
        inputPanel.add(eingabe4);

        JLabel eingabe5Label = new JLabel("x1");
        inputPanel.add(eingabe5Label);
        eingabe5 = new JTextField(20);
        inputPanel.add(eingabe5);

        JLabel eingabe6Label = new JLabel("x2");
        inputPanel.add(eingabe6Label);
        eingabe6 = new JTextField(20);
        inputPanel.add(eingabe6);

        JButton submitButton = new JButton("Eingabe");
        submitButton.addActionListener(event -> {
            MainFrame mainframe = new MainFrame();
            mainframe.setVisible(true);
            dispose();

            int iterations = Integer.parseInt(eingabe4.getText());
            double anfangswert1 = Float.parseFloat(eingabe5.getText());
            double anfangswert2 = Float.parseFloat(eingabe6.getText());

            double a = Float.parseFloat(eingabe1.getText());
            double b = Float.parseFloat(eingabe2.getText());
            double c = Float.parseFloat(eingabe3.getText());


            Bisektion bisektion = new Bisektion(a, b, c);
            String ausgabe = bisektion.bisektion(iterations, anfangswert1, anfangswert2);

            new MessageDialog(ausgabe);
        });

        inputPanel.add(submitButton);

        mainPanel.add(inputPanel);

        add(mainPanel);

        setSize(600, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}