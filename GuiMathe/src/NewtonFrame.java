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

    private final JTextField inputField1;
    private final JTextField inputField2;
    private final JTextField inputField3;
    private final JTextField inputField4;
    private final JTextField inputField5;

    public NewtonFrame() {
        super("Newton-Verfahren");

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

        JLabel inputField4Label = new JLabel("Anzahl Iterationen:");
        inputPanel.add(inputField4Label);
        inputField4 = new JTextField(20);
        inputPanel.add(inputField4);

        JLabel inputField5Label = new JLabel("Näherungswert:");
        inputPanel.add(inputField5Label);
        inputField5 = new JTextField(20);
        inputPanel.add(inputField5);

        JButton submitButton = new JButton("Eingabe");
        submitButton.addActionListener(event -> {
            MainFrame mainframe = new MainFrame();
            mainframe.setVisible(true);
            dispose();

            Newton newton = new Newton(
                    Float.parseFloat(inputField1.getText()),
                    Float.parseFloat(inputField2.getText()),
                    Float.parseFloat(inputField3.getText())
            );
            int iterations = Integer.parseInt(inputField4.getText());
            double naeherung = Float.parseFloat(inputField5.getText());

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