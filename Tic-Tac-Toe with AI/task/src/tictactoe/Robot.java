package tictactoe;
import java.util.Random;

public class Robot {
    public int cellY = 0;
    public int cellX = 0;

    public void setNewCell() {
        Random random = new Random();
        cellY = random.nextInt(3) + 1;
        cellX = random.nextInt(3) + 1;
    }
}
