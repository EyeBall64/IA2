import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMain extends JFrame implements ActionListener, DocumentListener {
    private JFrame mainFrame;
    private JPanel mainMenu;
    private JPanel testMenu;
    private JPanel tablePanel;



    public GUIMain() {

        mainFrame = new JFrame("Latin Noun Table Revision");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(0, 0, 365, 250);
        mainFrame.setLayout(null);

        //TODO: Add all panels, start hidden

        mainMenu();
        mainFrame.setVisible(true);
    }

    private void mainMenu(){ //TODO: repeat for other panels
        mainMenu = new JPanel();
        mainMenu.setBounds(0, 0, 365, 250);

        //test button
        JButton testButton = new JButton("Test");
        testButton.setBounds(20, 20, 50,30);
        testButton.addActionListener(this);
        mainMenu.add(testButton);
        mainFrame.add(mainMenu);

        //table button
        JButton tableButton = new JButton("Table");
        tableButton.setBounds(100, 20, 50,30);
        tableButton.addActionListener(this);
        mainMenu.add(tableButton);
        mainFrame.add(mainMenu);
    }

    private void testMenu(){
        testMenu = new JPanel();
        testMenu.setBounds(0, 0, 365, 250);

        //noTerm Button
        JButton noTermButton = new JButton("Test");
        noTermButton.setBounds(20, 20, 50,30);
        noTermButton.addActionListener(this);
        testMenu.add(noTermButton);
        mainFrame.add(testMenu);

        //shortTerm Button
        JButton shortTermButton = new JButton("Leave");
        shortTermButton.setBounds(100, 20, 50,30);
        shortTermButton.addActionListener(this);
        testMenu.add(shortTermButton);
        mainFrame.add(testMenu);

        //longTerm Button
        JButton longTermButton = new JButton("Table");
        longTermButton.setBounds(150, 20, 50,30);
        longTermButton.addActionListener(this);
        testMenu.add(longTermButton);
        mainFrame.add(testMenu);
    }

    private void table(){

        tablePanel = new JPanel();
        tablePanel.setBounds(0, 0, 365, 250);

        //Table table
        JTable tableTable = new JTable(noun,);
        tableTable.setBounds(150, 20, 50,30);
        testMenu.add(tableTable);
        mainFrame.add(tablePanel);

        //leave Button
        JButton leaveButton = new JButton("Leave");
        leaveButton.setBounds(100, 20, 50,30);
        leaveButton.addActionListener(this);
        testMenu.add(leaveButton);
        mainFrame.add(tablePanel);
    }


        @Override
    public void actionPerformed(ActionEvent e) {
        Table table = new Table();
        Test test = new Test();

        switch (e.getActionCommand()){
            case "Test" ->{
                //goes to test Menu
                mainMenu.setVisible(false);
                testMenu.setVisible(true);
                tablePanel.setVisible(false);
                testMenu();
            }
            case "Leave" ->{
                //goes to main Menu
                mainMenu.setVisible(true);
                testMenu.setVisible(false);
                tablePanel.setVisible(false);
                mainMenu();
            }
            case "Table" -> {
                //goes to table
                mainMenu.setVisible(false);
                testMenu.setVisible(false);
                tablePanel.setVisible(true);
                table.display();
            }
        }
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