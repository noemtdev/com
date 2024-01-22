import javax.swing.*;
import java.awt.*;

class Heron {

    // intellij hat rumgeheult, darum java.lang.String
    public static java.lang.String heron(int iterationen, double naeherungswert, double zahl) {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < iterationen; i++) {
            naeherungswert = 0.5*(naeherungswert+(zahl/naeherungswert));
            returnString.append(naeherungswert).append("\n");
        }
        return returnString.toString();
    }
}
public class HeronFrame extends JFrame {

    private final JTextField eingabe1;
    private final JTextField eingabe2;
    private final JTextField eingabe3;
    public HeronFrame() {
        super("Heron-Verfahren");

        JPanel mainPanel = new JPanel();
        JPanel inputPanel = new JPanel();

        setLayout(new BorderLayout());
        setLocationRelativeTo(null);


        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("");
        inputPanel.add(titleLabel);

        JLabel eingabe1Label = new JLabel("Zahl der Iterationen");
        inputPanel.add(eingabe1Label);
        eingabe1 = new JTextField(20);
        inputPanel.add(eingabe1);

        JLabel eingabe2Label = new JLabel("Für welche Zahl soll die Wurzel bestimmt werden?");
        inputPanel.add(eingabe2Label);
        eingabe2 = new JTextField(20);
        inputPanel.add(eingabe2);

        JLabel eingabe3Label = new JLabel("Gebe einen Näherungswert an");
        inputPanel.add(eingabe3Label);
        eingabe3 = new JTextField(20);
        inputPanel.add(eingabe3);

        JButton submitButton = new JButton("Eingabe");
        submitButton.addActionListener(event -> {
            MainFrame mainframe = new MainFrame();
            mainframe.setVisible(true);
            dispose();

            int iterations = Integer.parseInt(eingabe1.getText());
            double num = Float.parseFloat(eingabe2.getText());
            double naeherung = Float.parseFloat(eingabe3.getText());


            String ausgabe = Heron.heron(iterations, naeherung, num);

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