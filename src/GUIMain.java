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
        testMenu();
        table();

        mainMenu.setVisible(true);
        testMenu.setVisible(false);
        tablePanel.setVisible(false);


        mainFrame.setVisible(true);
    }

    private void mainMenu(){
        mainMenu = new JPanel();
        mainMenu.setBounds(0, 0, 365, 250);
        mainMenu.setLayout(null);

        //test button
        JButton testButton = new JButton("Test");
        testButton.setBounds(20, 20, 70,30);
        testButton.addActionListener(this);
        mainMenu.add(testButton);

        //table button
        JButton tableButton = new JButton("Table");
        tableButton.setBounds(100, 20, 70,30);
        tableButton.addActionListener(this);
        mainMenu.add(tableButton);

        mainFrame.add(mainMenu);
    }

    private void testMenu(){
        testMenu = new JPanel();
        testMenu.setBounds(0, 0, 365, 250);
        testMenu.setLayout(null);

        //noTerm Button
        JButton noTermButton = new JButton("no");
        noTermButton.setBounds(20, 20, 70,30);
        noTermButton.addActionListener(this);
        testMenu.add(noTermButton);

        //shortTerm Button
        JButton shortTermButton = new JButton("short");
        shortTermButton.setBounds(100, 20, 70,30);
        shortTermButton.addActionListener(this);
        testMenu.add(shortTermButton);

        //longTerm Button
        JButton longTermButton = new JButton("long");
        longTermButton.setBounds(150, 20, 70,30);
        longTermButton.addActionListener(this);
        testMenu.add(longTermButton);

        //leave Button
        JButton leaveButton = new JButton("Leave");
        leaveButton.setBounds(100, 100, 70,30);
        leaveButton.addActionListener(this);
        testMenu.add(leaveButton);

        mainFrame.add(testMenu);
    }

    private void table(){
        tablePanel = new JPanel();
        tablePanel.setBounds(0, 0, 365, 250);
        tablePanel.setLayout(null);
        Table table = new Table();

        String[] columnTitles = new String[9];
        String[][] grid = new String[12][9];

        for (int y = 0; y < 9; y++) {
            columnTitles[y] = table.getTable(0,y);
        }
        for (int x = 0; x < 12; x++) {
            for (int y = 0; y < 9; y++) {
                grid[x][y] = table.getTable(x,y);
                JLabel tableLabel = new JLabel(table.getTable(x,y));
                tableLabel.setBounds(y*100, 70+x*20, 100,30);
                tablePanel.add(tableLabel);
                mainFrame.add(tableLabel);
            }
        }



        //leave Button
        JButton leaveButton = new JButton("Leave");
        leaveButton.setBounds(100, 20, 70,30);
        leaveButton.addActionListener(this);
        tablePanel.add(leaveButton);
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
            }
            case "Leave" ->{
                //goes to main Menu
                mainMenu.setVisible(true);
                testMenu.setVisible(false);
                tablePanel.setVisible(false);
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