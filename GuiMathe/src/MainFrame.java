import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        super("Startmenu");

        setLayout(new GridLayout(2, 2));
        setLocationRelativeTo(null);

        JButton newtonKnopf = new JButton("Newton-Verfahren");
        newtonKnopf.addActionListener(event -> {
            NewtonFrame newtonframe = new NewtonFrame();
            newtonframe.setVisible(true);
            dispose();
        });
        add(newtonKnopf);

        JButton heronKnopf = new JButton("Heron-Verfahren");
        heronKnopf.addActionListener(event -> {
            HeronFrame heronframe = new HeronFrame();
            heronframe.setVisible(true);
            dispose();
        });
        add(heronKnopf);

        JButton falsiKnopf = new JButton("Regula Falsi-Verfahren");
        falsiKnopf.addActionListener(event -> {
            FalsiFrame falsiframe = new FalsiFrame();
            falsiframe.setVisible(true);
            dispose();
        });
        add(falsiKnopf);

        JButton bisktionKnopf = new JButton("Bisektionsverfahren");
        bisktionKnopf.addActionListener(event -> {
            BisektionFrame bisektionframe = new BisektionFrame();
            bisektionframe.setVisible(true);
            dispose();
        });
        add(bisktionKnopf);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
