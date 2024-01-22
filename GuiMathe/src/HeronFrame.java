import javax.swing.*;
import java.awt.*;
class Heron {
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

    private final JTextField inputField1;
    private final JTextField inputField2;
    private final JTextField inputField3;
    public HeronFrame() {
        super("Heron-Verfahren");

        JPanel mainPanel = new JPanel();
        JPanel inputPanel = new JPanel();

        setLayout(new BorderLayout());
        setLocationRelativeTo(null);


        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("");
        inputPanel.add(titleLabel);

        JLabel inputField1Label = new JLabel("Zahl der Iterationen");
        inputPanel.add(inputField1Label);
        inputField1 = new JTextField(20);
        inputPanel.add(inputField1);

        JLabel inputField2Label = new JLabel("Für welche Zahl soll die Wurzel bestimmt werden?");
        inputPanel.add(inputField2Label);
        inputField2 = new JTextField(20);
        inputPanel.add(inputField2);

        JLabel inputField3Label = new JLabel("Gebe einen Näherungswert an");
        inputPanel.add(inputField3Label);
        inputField3 = new JTextField(20);
        inputPanel.add(inputField3);

        JButton submitButton = new JButton("Eingabe");
        submitButton.addActionListener(event -> {
            MainFrame mainframe = new MainFrame();
            mainframe.setVisible(true);
            dispose();

            int iterations = Integer.parseInt(inputField1.getText());
            double num = Float.parseFloat(inputField2.getText());
            double naeherung = Float.parseFloat(inputField3.getText());


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