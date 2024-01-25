import javax.swing.*;

public class MessageDialog extends JDialog {

    public MessageDialog(String message) {
        super();

        setTitle("Ausgabe");

        JTextArea messageArea = new JTextArea(message);
        messageArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(messageArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

