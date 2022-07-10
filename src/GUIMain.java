import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.Objects;
import java.util.Random;

public class GUIMain extends JFrame implements ActionListener, DocumentListener {
    private JFrame mainFrame;
    private JPanel mainMenu;
    private JPanel testMenu;
    private JPanel tablePanel;
    private JPanel quickTest;
    private JPanel shortTest;
    private JPanel longTest;
    private JLabel quickQuestionLabel;
    private JLabel shortQuestionLabel;
    private JLabel longQuestionLabel;
    private JLabel correctAnswer;
    private JButton longButton;
    private JButton shortButton;
    private JTextField quickAnswer;
    private JTextField shortAnswer;
    private JTextField longAnswer;
    private Test test;
    private JLabel correctLabel;
    private String testType;
    private boolean viewTableLong = true;

    public GUIMain() {
        mainFrame = new JFrame("Latin Noun Table Revision");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(0, 0, 1000, 700);
        mainFrame.setLayout(null);

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
        quickQuestionLabel.setVisible(true);
        shortQuestionLabel.setVisible(true);
        longQuestionLabel.setVisible(true);


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
        test = new Test();

        quickQuestionLabel = new JLabel();
        quickQuestionLabel.setBounds(120, 60, 370,30);
        tablePanel.add(quickQuestionLabel);
        quickTest.add(quickQuestionLabel);

        correctAnswer = new JLabel("The answer was " + test.getAnswer());
        correctAnswer.setBounds(350, 100, 200,30);
        correctAnswer.setForeground(new Color(250,0,0));
        correctAnswer.setVisible(false);
        tablePanel.add(correctAnswer);
        quickTest.add(correctAnswer);

        //back textfield
        quickAnswer = new JTextField("");
        quickAnswer.setBounds(120, 100, 70,30);
        quickTest.add(quickAnswer);

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
        test = new Test();

        shortQuestionLabel = new JLabel();
        shortQuestionLabel.setBounds(120, 60, 370,30);
        tablePanel.add(shortQuestionLabel);
        shortTest.add(shortQuestionLabel);

        correctLabel = new JLabel("INCORRECT!!!");
        correctLabel.setBounds(350, 100, 100,30);
        correctLabel.setForeground(new Color(250,0,0));
        correctLabel.setVisible(false);
        tablePanel.add(correctLabel);
        shortTest.add(correctLabel);

        //back textfield
        shortAnswer = new JTextField("");
        shortAnswer.setBounds(120, 100, 70,30);
        shortTest.add(shortAnswer);

        //confirm Button
        JButton confirmButton = new JButton("confirm");
        confirmButton.setBounds(200, 100, 100,30);
        confirmButton.addActionListener(this);
        shortTest.add(confirmButton);

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
        test = new Test();

        longQuestionLabel = new JLabel();
        longQuestionLabel.setBounds(120, 60, 370,30);
        tablePanel.add(longQuestionLabel);
        longTest.add(longQuestionLabel);

        correctLabel = new JLabel("INCORRECT!!!");
        correctLabel.setBounds(350, 100, 100,30);
        correctLabel.setForeground(new Color(250,0,0));
        correctLabel.setVisible(false);
        tablePanel.add(correctLabel);
        longTest.add(correctLabel);

        //back textfield
        longAnswer = new JTextField("");
        longAnswer.setBounds(120, 100, 70,30);
        longTest.add(longAnswer);

        //confirm Button
        JButton confirmButton = new JButton("confirm");
        confirmButton.setBounds(200, 100, 100,30);
        confirmButton.addActionListener(this);
        longTest.add(confirmButton);

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
                    if(viewTableLong) {
                        tableLabel.setForeground(new Color((table.getScore(x - 1, y - 1)) * (255 / 99), 255 - ((table.getScore(x - 1, y - 1)) * (255 / 99)), 0));
                    }else{
                        tableLabel.setForeground(new Color((test.getShortTermScore(x - 1, y - 1)) * (255 / 99), 255 - ((test.getShortTermScore(x - 1, y - 1)) * (255 / 99)), 0));
                    }
                    tablePanel.add(tableLabel);
                    mainFrame.add(tablePanel);
                }
            }
        }

        //toggleLength Button
        longButton = new JButton("Long");
        longButton.setBounds(200, 20, 200,30);
        longButton.addActionListener(this);
        tablePanel.add(longButton);

        //toggleLength Button
        shortButton = new JButton("Short");
        shortButton.setBounds(200, 20, 200,30);
        shortButton.addActionListener(this);
        tablePanel.add(shortButton);

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
                correctLabel.setVisible(false);
            }
            case "Short" ->{
                System.out.println("SHPORT");
                viewTableLong = !viewTableLong;
                longButton.setVisible(true);
                shortButton.setVisible(false);
            }
            case "Long" ->{
                System.out.println("LONG");
                viewTableLong = !viewTableLong;
                longButton.setVisible(false);
                shortButton.setVisible(true);
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
                testType = "quick";
                quickQuestionLabel.setText(test.getQuestion(testType));
                mainMenu.setVisible(false);
                testMenu.setVisible(false);
                tablePanel.setVisible(false);
                quickTest.setVisible(true);
                shortTest.setVisible(false);
                longTest.setVisible(false);
            }
            case "short" -> {
                //goes to short test
                testType = "short";
                shortQuestionLabel.setText(test.getQuestion(testType));
                mainMenu.setVisible(false);
                testMenu.setVisible(false);
                tablePanel.setVisible(false);
                quickTest.setVisible(false);
                shortTest.setVisible(true);
                longTest.setVisible(false);
            }
            case "long" -> {
                //goes to quick test
                testType = "long";
                longQuestionLabel.setText(test.getQuestion(testType));
                mainMenu.setVisible(false);
                testMenu.setVisible(false);
                tablePanel.setVisible(false);
                quickTest.setVisible(false);
                shortTest.setVisible(false);
                longTest.setVisible(true);
            }
            case "confirm" -> {
                switch (testType) {
                    case "quick":
                        if (test.isAnswerCorrect(quickAnswer.getText())) {
                            correctAnswer.setVisible(false);
                        } else {
                            correctAnswer.setVisible(true);
                        }
                        quickQuestionLabel.setText(test.getQuestion(testType));
                        correctAnswer.setText("The answer was " + test.getAnswer());
                        break;
                    case "short":
                        test.editShortTerm(shortAnswer.getText());
                        System.out.println(test.isAnswerCorrect(shortAnswer.getText()));
                        if (test.isAnswerCorrect(shortAnswer.getText())) {
                            shortQuestionLabel.setText(test.getQuestion(testType));
                            correctLabel.setVisible(false);
                        } else {
                            correctLabel.setVisible(true);
                        }
                        break;
                    case "long":
                        test.editLongTerm(longAnswer.getText());
                        if (test.isAnswerCorrect(longAnswer.getText())) {
                            longQuestionLabel.setText(test.getQuestion(testType));
                            correctLabel.setVisible(false);
                        } else {
                            correctLabel.setVisible(true);
                        }
                        break;
                }
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