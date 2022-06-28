import java.util.Random;
import java.util.Scanner;

public class Test {
    private static String[][] endings;
    private static DataBase noun;
    Scanner myScanner = new Scanner(System.in);
    Random rand = new Random();

    public Test() {
        noun = new DataBase("C:\\Users\\16Hurley_J\\IdeaProjects\\IA3\\src\\LatinNouns.txt",30,10);
        endings = new String[7][3];

        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 3; y++) {
                endings[x][y] = (noun.getRecord(x, y));
            }
        }
    }

    public void unweightedTest() {
        Boolean[][] questions = {{false, false}, {false, false}, {false, false}, {false, false}, {false, false}, {false, false}};
        int yRandom;
        int xRandom;

        for (int i = 0; i < 12; i++) {
            do {
                yRandom = rand.nextInt(2);
                xRandom = rand.nextInt(6);
                //randomises question asked
            }
            while (questions[xRandom][yRandom]); //makes sure the same question isn't asked twice

            questions[xRandom][yRandom] = true;
            System.out.println("what is " + (endings[xRandom + 1][0]).trim() + " " + (endings[0][yRandom + 1]).trim());
            String answer = myScanner.nextLine();
            if (answer.trim().equals((endings[xRandom + 1][yRandom + 1]).trim())) {
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
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 2; j++) {
                    total = total + FileScore.getShortTermScore(i, j);
                }
            }
            int random = rand.nextInt(total);
            //System.out.println(total);
            //System.out.println(random);

            outerLoop:
            for (int i = 1; i < 7; i++) {
                for (int j = 1; j < 3; j++) {
                    runningTotal = runningTotal + FileScore.getShortTermScore(i, j);
                    if (random <= runningTotal) {
                        y = j;
                        x = i;
                        break outerLoop;
                    }
                }
            }

            System.out.println("what is " + (endings[x][0]).trim() + " " + (endings[0][y]).trim());
            String answer = myScanner.nextLine();
            if (answer.trim().equals((endings[x][y]).trim())) {
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