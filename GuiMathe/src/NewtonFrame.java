import javax.swing.*;
import java.awt.*;

class Newton {
    static double a;
    static double b;
    static double c;

    public Newton(double a, double b, double c) {
        Newton.a = a;
        Newton.b = b;
        Newton.c = c;
    }

    public static double funktionswert(double x) {
        return a*x*x + b*x + c;
    }

    public static double ableitungswert(double x) {
        return 2*a*x + b;
    }
    public static String newton(int iterationen, double naeherungswert) {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < iterationen; i++) {
            naeherungswert = naeherungswert-(funktionswert(naeherungswert)/(ableitungswert(naeherungswert)));
            returnString.append(naeherungswert).append("\n");
        }
        return returnString.toString();
    }
}

public class NewtonFrame extends JFrame {

    private final JTextField eingabe1;
    private final JTextField eingabe2;
    private final JTextField eingabe3;
    private final JTextField eingabe4;
    private final JTextField eingabe5;

    public NewtonFrame() {
        super("Newton-Verfahren");

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

        JLabel eingabe4Label = new JLabel("Anzahl Iterationen:");
        inputPanel.add(eingabe4Label);
        eingabe4 = new JTextField(20);
        inputPanel.add(eingabe4);

        JLabel eingabe5Label = new JLabel("Näherungswert:");
        inputPanel.add(eingabe5Label);
        eingabe5 = new JTextField(20);
        inputPanel.add(eingabe5);

        JButton submitButton = new JButton("Eingabe");
        submitButton.addActionListener(event -> {
            MainFrame mainframe = new MainFrame();
            mainframe.setVisible(true);
            dispose();

            Newton newton = new Newton(
                    Float.parseFloat(eingabe1.getText()),
                    Float.parseFloat(eingabe2.getText()),
                    Float.parseFloat(eingabe3.getText())
            );
            int iterations = Integer.parseInt(eingabe4.getText());
            double naeherung = Float.parseFloat(eingabe5.getText());

            String ausgabe = newton.newton(iterations, naeherung);
            new MessageDialog(ausgabe);
        });

        inputPanel.add(submitButton);

        mainPanel.add(inputPanel);

        add(mainPanel);

        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}