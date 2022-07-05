public class FileScore {
    //TODO: Get rid of if necessary

    private static int[][] shortTermScore = new int[13][9];

    public static void setShortTermScore(int x, int y,int shortTermScore) {
        FileScore.shortTermScore[x][y] = shortTermScore;
    }

    public static int getShortTermScore(int x, int y){
        return shortTermScore[x][y];
    }
    public static void changeShortTermScore(int x, int y, int score){
        shortTermScore[x][y] = shortTermScore[x][y] + score;
        if(shortTermScore[x][y] < 0){
            shortTermScore[x][y] =0;
        }else if(shortTermScore[x][y] > 99){
            shortTermScore[x][y] = 99;
        }
    }
}
