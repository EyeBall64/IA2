import java.util.Arrays;
public class FileNouns {
    private String[][] grid;

    public FileNouns() {
        grid = new String[7][3];
        grid[0][0] = "          "; grid[0][1] = "Singular  "; grid[0][2] = "Plural    ";
        grid[1][0] = "Nominative"; grid[1][1] = "a         "; grid[1][2] = "e         ";
        grid[2][0] = "Vocative  "; grid[2][1] = "a         "; grid[2][2] = "e         ";
        grid[3][0] = "Accusative"; grid[3][1] = "am        "; grid[3][2] = "as        ";
        grid[4][0] = "Genitive  "; grid[4][1] = "e         "; grid[4][2] = "arum      ";
        grid[5][0] = "Dative    "; grid[5][1] = "e         "; grid[5][2] = "is        ";
        grid[6][0] = "Ablative  "; grid[6][1] = "a         "; grid[6][2] = "is        ";
    }

    public String getNouns(int x, int y){
        return grid[x][y];
    }
}