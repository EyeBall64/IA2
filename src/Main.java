import java.util.Scanner;

public class Main {
//TODO: redo for inheritance
    public static void main(String[] args) {


        String direction;
        Table table = new Table();
        Test test = new Test();
        for(int i = 0;i< 7;i++){
            for(int j = 0;j<3;j++){
                FileScore.setShortTermScore(i,j,50);
            }
        }

        do {
            System.out.println("test u --> unweighted test");
            System.out.println("table ---> Table");
            System.out.println("test s --> weighted test");
            System.out.println("leave ---> leaves");

            Scanner myScanner = new Scanner(System.in);
            direction = myScanner.nextLine().toLowerCase().trim();

            if(direction.equals("test u")) {
                //goes to unweighted test
                test.unweightedTest();
                direction = "X";
            }else if(direction.equals("table")) {
                //goes to table
                table.display();
                direction = "X";
            }else if(direction.equals("test s")){
                //goes to weighted test
                test.shortTermTest();
                direction = "X";
            }
        }
        while(!direction.equals("leave"));
        System.out.println("bye");
    }
}
