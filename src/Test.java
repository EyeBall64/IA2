import java.util.Random;
import java.util.Scanner;

public class Test {
    Scanner myScanner = new Scanner(System.in);
    Random rand = new Random();
    private int yRandom;
    private int xRandom;
    Table table = new Table();
    private DataBase scoreDataBase;


    public String getQuestion(){
        yRandom = rand.nextInt(8)+1;
        xRandom = rand.nextInt(12)+1;
        System.out.println(getAnswer());
        return "What is "+ (table.getTable(xRandom,0)).trim() + " " + (table.getTable(0,yRandom)).trim()+ "?";
    }

    public boolean isAnswerCorrect(String entered){
        return entered.trim().equals(table.getTable(xRandom,yRandom).trim());
    }

    public void editShortTerm(String entered){

    }

    public void editLongTerm(String entered){
        int newScore;

        System.out.println(entered.trim().equals(table.getTable(xRandom,yRandom).trim()));
        if(entered.trim().equals(table.getTable(xRandom,yRandom).trim())){
            newScore = Integer.parseInt(scoreDataBase.getRecord(xRandom-1,yRandom-1))+1;
        }else{
            newScore = Integer.parseInt(scoreDataBase.getRecord(xRandom-1,yRandom-1))-1;
        }

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



    public void unweightedTest() {


        for (int i = 0; i < 96; i++) {


                //randomises question asked

            System.out.println("what is " + (table.getTable(xRandom + 1,0)).trim() + " " + (table.getTable(0,yRandom + 1)).trim());
            String answer = myScanner.nextLine();
            if (answer.trim().equals((table.getTable(xRandom + 1,yRandom + 1)).trim())) {
                System.out.println("Correct");
                FileScore.changeShortTermScore(xRandom, yRandom, -1);
            } else {
                System.out.println("Wrong");
                FileScore.changeShortTermScore(xRandom, yRandom, 1);
            }
        }
    }

    public void shortTermTest() {
        String leave;
        int total = 0;
        int runningTotal = 0;
        int x = 0;
        int y = 0;

        do {
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 8; j++) {
                    total = total + FileScore.getShortTermScore(i, j);
                }
            }
            int random = rand.nextInt(total);
            //System.out.println(total);
            //System.out.println(random);

            outerLoop:
            for (int i = 1; i < 13; i++) {
                for (int j = 1; j < 9; j++) {
                    runningTotal = runningTotal + FileScore.getShortTermScore(i, j);
                    if (random <= runningTotal) {
                        y = j;
                        x = i;
                        break outerLoop;
                    }
                }
            }

            System.out.println("what is " + (table.getTable(x,0)).trim() + " " + (table.getTable(0,y)).trim());
            String answer = myScanner.nextLine();
            if (answer.trim().equals((table.getTable(x,y)).trim())) {
                System.out.println("Correct");
                FileScore.changeShortTermScore(x-1, y-1, -1);
            } else {
                System.out.println("Wrong");
                FileScore.changeShortTermScore(x-1, y-1, 1);
            }

            System.out.println("do you want to leave");
            leave = myScanner.nextLine();
            runningTotal = 0;
            total = 0;
        }
        while (leave.equals("stay"));
    }
}