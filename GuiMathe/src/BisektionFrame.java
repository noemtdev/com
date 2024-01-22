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

    private final JTextField inputField1;
    private final JTextField inputField2;
    private final JTextField inputField3;
    private final JTextField inputField4;
    private final JTextField inputField5;
    private final JTextField inputField6;

    public BisektionFrame() {
        super("Bisektion-Verfahren");

        JPanel mainPanel = new JPanel();
        JPanel inputPanel = new JPanel();

        setLayout(new BorderLayout());
        setLocationRelativeTo(null);


        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Die Form einer quadratischen Funktion ist ist ax²+ bx + c");
        inputPanel.add(titleLabel);

        JLabel inputField1Label = new JLabel("a:");
        inputPanel.add(inputField1Label);
        inputField1 = new JTextField(20);
        inputPanel.add(inputField1);

        JLabel inputField2Label = new JLabel("b:");
        inputPanel.add(inputField2Label);
        inputField2 = new JTextField(20);
        inputPanel.add(inputField2);

        JLabel inputField3Label = new JLabel("c:");
        inputPanel.add(inputField3Label);
        inputField3 = new JTextField(20);
        inputPanel.add(inputField3);

        JLabel inputField4Label = new JLabel("Zahl der Iterationen");
        inputPanel.add(inputField4Label);
        inputField4 = new JTextField(20);
        inputPanel.add(inputField4);

        JLabel inputField5Label = new JLabel("x1");
        inputPanel.add(inputField5Label);
        inputField5 = new JTextField(20);
        inputPanel.add(inputField5);

        JLabel inputField6Label = new JLabel("x2");
        inputPanel.add(inputField6Label);
        inputField6 = new JTextField(20);
        inputPanel.add(inputField6);

        JButton submitButton = new JButton("Eingabe");
        submitButton.addActionListener(event -> {
            MainFrame mainframe = new MainFrame();
            mainframe.setVisible(true);
            dispose();

            int iterations = Integer.parseInt(inputField4.getText());
            double anfangswert1 = Float.parseFloat(inputField5.getText());
            double anfangswert2 = Float.parseFloat(inputField6.getText());

            double a = Float.parseFloat(inputField1.getText());
            double b = Float.parseFloat(inputField2.getText());
            double c = Float.parseFloat(inputField3.getText());


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