public class Table {
    private String [][] endings;
    private int[][] score;
    private DataBase noun;

    public Table(){
        noun = new DataBase("LatinNouns.txt",135,15);
        endings = new String[13][9];
        score = new int[12][8];
        for(int x=0;x<12;x++){
            for(int y=0;y<8;y++){
                endings[x][y] = noun.getRecord(x,y).replace("|","");
            }
        }
    }

    public void display(){
        //gets the score for the endings
        for(int x = 0; x < 12; x++){
            for(int y = 0; y < 8; y++){
                score[x][y] = (FileScore.getShortTermScore(x,y));
            }
        }
        printTable();
        printScore();
    }

    public void printTable(){
        //prints out the table
        for(int x=0;x<12;x++){
            for(int y=0;y<8;y++){
                if(y == 7) {
                    System.out.println(endings[x][y]);
                }else{
                    System.out.print(endings[x][y]);
                    System.out.print("|");
                }
            }
        }
    }

    public String getTable(int x, int y){
        //gets the table
        return endings[x][y];
    }
    public int getScore(int x, int y) {
        //prints out score
        return score[x][y];
    }

    public void printScore(){
        //prints out score
        for(int x=0;x<12;x++){
            for(int y=0;y<8;y++){
                if(y == 0 || x == 0) {
                    if(y == 7){
                        System.out.println("          ");
                    }else {
                        System.out.print("          ");
                    }
                }else if(y == 2){
                    System.out.print("|");
                    System.out.println(score[x-1][y-1]);

                }else{
                    System.out.print("|");
                    System.out.print(score[x-1][y-1]);
                    System.out.print("        ");
                }
            }
        }
    }


}