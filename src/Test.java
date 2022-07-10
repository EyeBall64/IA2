import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Test {
    Scanner myScanner = new Scanner(System.in);
    Random rand = new Random();
    private int yRandom;
    private int xRandom;
    Table table = new Table();
    private DataBase scoreDataBase = new DataBase("Score.txt",16,2);
    private static int[][] shortTermScore = new int[13][9];

    public Test() {
        for (int x = 0; x < 12; x++) {
            for (int y = 0; y < 8; y++) {
                shortTermScore[x][y] = table.getScore(x, y);
            }
        }
    }

    public String getQuestion(String testType){
        if (testType.equals("quick")) {
            yRandom = rand.nextInt(8) + 1;
            xRandom = rand.nextInt(12) + 1;
        }else if(testType.equals("short")){
            shortTermTest();
        }else{
            longTermTest();
        }
        System.out.println(getAnswer());
        return "What is "+ (table.getTable(xRandom,0)).trim() + " " + (table.getTable(0,yRandom)).trim()+ "?";
    }

    public boolean isAnswerCorrect(String entered){
        return entered.trim().equals(table.getTable(xRandom,yRandom).trim());
    }

    public void editShortTerm(String entered){
        if (entered.trim().equals((table.getTable(xRandom,yRandom)).trim())) {
            changeShortTermScore(xRandom-1, yRandom-1, -1);
        } else {
            changeShortTermScore(xRandom-1, yRandom-1, 1);
        }
    }

    public static void changeShortTermScore ( int x, int y, int score){
        shortTermScore[x][y] = shortTermScore[x][y] + score;
        if (shortTermScore[x][y] < 0) {
            shortTermScore[x][y] = 0;
        } else if (shortTermScore[x][y] > 99) {
            shortTermScore[x][y] = 99;
        }
    }

    public void editLongTerm(String entered){
        int newScore;
        System.out.println(entered.trim().equals(table.getTable(xRandom,yRandom).trim()));
        if(entered.trim().equals(table.getTable(xRandom,yRandom).trim())){
            newScore = Integer.parseInt(scoreDataBase.getRecord(xRandom-1,yRandom-1))+1;
            System.out.println("correct");
        }else{
            newScore = Integer.parseInt(scoreDataBase.getRecord(xRandom-1,yRandom-1))-1;
            System.out.println("wrong");
        }

        System.out.println("score: "+ newScore);

        if(newScore > 99){
            newScore = 99;
        }else if (newScore < 0){
            newScore = 0;
        }

        scoreDataBase.editRecord( String.valueOf(newScore),xRandom-1,yRandom-1);
    }

    public String getAnswer(){
        return table.getTable(xRandom,yRandom);
    }
    public int getShortTermScore ( int x, int y){
        return shortTermScore[x][y];
    }


    public void shortTermTest() {
        int total = 0;
        int runningTotal = 0;

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 8; j++) {
                total = total + getShortTermScore(i, j);
            }
        }
        System.out.println(total);
        int random = rand.nextInt(total);
        outerLoop:
        for (int i = 1; i < 13; i++) {
            for (int j = 1; j < 9; j++) {
                runningTotal = runningTotal + getShortTermScore(i, j);
                if (random <= runningTotal) {
                    yRandom = j+1;
                    xRandom = i+1;
                    break outerLoop;
                }
            }
        }
    }

    public void longTermTest() {
        int total = 0;
        int runningTotal = 0;

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 8; j++) {
                    total = total + table.getScore(i, j);
                }
            }
            int random = rand.nextInt(total);
            outerLoop:
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 8; j++) {
                    runningTotal = runningTotal + table.getScore(i, j);
                    if (random <= runningTotal) {
                        yRandom = j+1;
                        xRandom = i+1;
                        break outerLoop;
                    }
                }
            }
        }
    }