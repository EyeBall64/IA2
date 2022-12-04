public class Table {
    private String [][] endings;
    private int[][] score;
    private DataBase noun;
    private DataBase scoreDataBase;

    public Table(){
        noun = new DataBase("LatinNouns.txt",135,15);
        scoreDataBase = new DataBase("Score.txt",16,2);

        endings = new String[13][9];
        score = new int[12][8];
        for(int x=0;x<13;x++){
            for(int y=0;y<9;y++){
                endings[x][y] = noun.getRecord(x,y).replace("|","");
            }
        }
        for(int x = 0; x < 12; x++){
            for(int y = 0; y < 8; y++){
                score[x][y] = Integer.parseInt(scoreDataBase.getRecord(x,y));
            }
        }
    }

    public String getTable(int x, int y){
        //returns a noun ending corosponding to the coordinates
        return endings[x][y];
    }
    public int getScore(int x, int y) {
        //returns the score
        return score[x][y];
    }
}