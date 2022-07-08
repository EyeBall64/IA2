import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.Random;

public class GUIMain extends JFrame implements ActionListener, DocumentListener {
    private JFrame mainFrame;
    private JPanel mainMenu;
    private JPanel testMenu;
    private JPanel tablePanel;
    private JPanel quickTest;
    private JPanel shortTest;
    private JPanel longTest;

    public GUIMain() {
        mainFrame = new JFrame("Latin Noun Table Revision");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(0, 0, 1000, 700);
        mainFrame.setLayout(null);
        Random rand = new Random();

        //TODO: Add all panels, start hidden

        mainMenu();
        testMenu();
        table();
        quickTest();
        shortTest();
        longTest();

        mainMenu.setVisible(true);
        testMenu.setVisible(false);
        tablePanel.setVisible(false);
        quickTest.setVisible(false);
        shortTest.setVisible(false);
        longTest.setVisible(false);

        mainFrame.setVisible(true);
    }

    private void mainMenu(){
        mainMenu = new JPanel();
        mainMenu.setBounds(0, 0, 1000, 700);
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
        testMenu.setBounds(0, 0, 1000, 700);
        testMenu.setLayout(null);

        //noTerm Button
        JButton quickButton = new JButton("quick");
        quickButton.setBounds(20, 20, 70,30);
        quickButton.addActionListener(this);
        testMenu.add(quickButton);

        //shortTerm Button
        JButton shortTermButton = new JButton("short");
        shortTermButton.setBounds(120, 20, 70,30);
        shortTermButton.addActionListener(this);
        testMenu.add(shortTermButton);

        //longTerm Button
        JButton longTermButton = new JButton("long");
        longTermButton.setBounds(220, 20, 70,30);
        longTermButton.addActionListener(this);
        testMenu.add(longTermButton);

        //leave Button
        JButton leaveButton = new JButton("Leave");
        leaveButton.setBounds(120, 60, 70,30);
        leaveButton.addActionListener(this);
        testMenu.add(leaveButton);

        mainFrame.add(testMenu);
    }

    private void quickTest() {
        quickTest = new JPanel();
        quickTest.setBounds(0, 0, 1000, 700);
        quickTest.setLayout(null);
        Test test = new Test();
        Random rand = new Random();
        Table table = new Table();

        int yRandom;
        int xRandom;

        yRandom = rand.nextInt(8);
        xRandom = rand.nextInt(12);

        JLabel questionLabel = new JLabel("what is " + table.getTable(0,yRandom+1) + " " + table.getTable(xRandom+1,0));
        questionLabel.setBounds(120, 60, 370,30);
        tablePanel.add(questionLabel);
        quickTest.add(questionLabel);

        //back textfield
        JTextField answer = new JTextField("");
        answer.setBounds(120, 100, 70,30);
        answer.addActionListener(this);
        quickTest.add(answer);

        //confirm Button
        JButton confirmButton = new JButton("confirm");
        confirmButton.setBounds(200, 100, 100,30);
        confirmButton.addActionListener(this);
        quickTest.add(confirmButton);

        //back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(150, 260, 70,30);
        backButton.addActionListener(this);
        quickTest.add(backButton);

        mainFrame.add(quickTest);
    }
    private void shortTest() {
        shortTest = new JPanel();
        shortTest.setBounds(0, 0, 1000, 700);
        shortTest.setLayout(null);

        //back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(150, 260, 70,30);
        backButton.addActionListener(this);
        shortTest.add(backButton);

        mainFrame.add(shortTest);
    }
    private void longTest() {
        longTest = new JPanel();
        longTest.setBounds(0, 0, 1000, 700);
        longTest.setLayout(null);

        //back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(150, 260, 70,30);
        backButton.addActionListener(this);
        longTest.add(backButton);

        mainFrame.add(longTest);
    }

    private void table(){
        tablePanel = new JPanel();
        tablePanel.setBounds(0, 0, 1000, 700);
        tablePanel.setLayout(null);
        Table table = new Table();

        for (int x = 0; x < 13; x++) {
            for (int y = 0; y < 9; y++) {
                if(y==0 || x==0) {
                    JLabel tableLabel = new JLabel(table.getTable(x, y));
                    tableLabel.setBounds(y * 100, 70 + x * 20, 100, 30);
                    tablePanel.add(tableLabel);
                    mainFrame.add(tablePanel);
                }else{
                    JLabel tableLabel = new JLabel(table.getTable(x, y));
                    tableLabel.setBounds(y * 100, 70 + x * 20, 100, 30);
                    tableLabel.setForeground(new Color((table.getScore(x-1, y-1))*(255/99), 255-((table.getScore(x-1, y-1))*(255/99)),0 )); //(table.getScore(x-1, y-1))
                    tablePanel.add(tableLabel);
                    mainFrame.add(tablePanel);
                }
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
            case "Leave" ->{
                //goes to main Menu
                mainMenu.setVisible(true);
                testMenu.setVisible(false);
                tablePanel.setVisible(false);
                quickTest.setVisible(false);
                shortTest.setVisible(false);
                longTest.setVisible(false);
            }
            case "Test", "Back" ->{
                //goes to test Menu
                mainMenu.setVisible(false);
                testMenu.setVisible(true);
                tablePanel.setVisible(false);
                quickTest.setVisible(false);
                shortTest.setVisible(false);
                longTest.setVisible(false);
            }
            case "Table" -> {
                //goes to table
                mainMenu.setVisible(false);
                testMenu.setVisible(false);
                tablePanel.setVisible(true);
                quickTest.setVisible(false);
                shortTest.setVisible(false);
                longTest.setVisible(false);
            }
            case "quick" -> {
                //goes to quick test
                mainMenu.setVisible(false);
                testMenu.setVisible(false);
                tablePanel.setVisible(false);
                quickTest.setVisible(true);
                shortTest.setVisible(false);
                longTest.setVisible(false);
            }
            case "short" -> {
                //goes to short test
                mainMenu.setVisible(false);
                testMenu.setVisible(false);
                tablePanel.setVisible(false);
                quickTest.setVisible(false);
                shortTest.setVisible(true);
                longTest.setVisible(false);
            }
            case "long" -> {
                //goes to quick test
                mainMenu.setVisible(false);
                testMenu.setVisible(false);
                tablePanel.setVisible(false);
                quickTest.setVisible(false);
                shortTest.setVisible(false);
                longTest.setVisible(true);
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