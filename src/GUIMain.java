import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMain extends JFrame implements ActionListener, DocumentListener {
    private JFrame mainFrame;

    public GUIMain() {
        mainFrame = new JFrame("Latin Noun Table Revision");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(0, 0, 365, 250);
        mainFrame.setLayout(null);















        mainFrame.setVisible(true);
    }

    private void mainMenu(){ //TODO: repeat for other panels
        JPanel main = new JPanel();
        main.setBounds(0, 0, 365, 250);

        JButton testButton = new JButton("Test");
        testButton.setBounds(); //TODO:finish here
        main.add(testButton);
        //TODO:repeat for rest of components
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // triggers when the style of the text changes
        System.out.println("change!");
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        System.out.println("remove!");
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        System.out.println("insert!");
    }
}