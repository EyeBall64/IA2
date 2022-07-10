public class FileScore {
    //TODO: Get rid of if necessary

    private static int[][] shortTermScore = new int[13][9];
    Table table = new Table();

    public FileScore() {
        for (int x = 0; x < 13; x++) {
            for (int y = 0; y < 9; y++) {
                shortTermScore[x][y] = table.getScore(x, y);
                System.out.println(shortTermScore[x][y]);
            }
        }
    }

    public static int getShortTermScore ( int x, int y){
        System.out.println(shortTermScore[x][y]);
        return shortTermScore[x][y];
    }

    public static void changeShortTermScore ( int x, int y, int score){
        shortTermScore[x][y] = shortTermScore[x][y] + score;
        if (shortTermScore[x][y] < 0) {
            shortTermScore[x][y] = 0;
        } else if (shortTermScore[x][y] > 99) {
            shortTermScore[x][y] = 99;
        }
    }
}