package tictactoe;

public class Main {
    static TicTacToe game;
    static Player player;
    static Robot robot;

    public static void makePlayerMove() {
        boolean keepAsking = true;
        while (keepAsking) {
            player.getCoordinates();
            if (player.correctInput) {
                game.setNewCell(player.cellY, player.cellX);
                if (game.isCellOccupied()) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    keepAsking = false;
                }
            }
        }
    }

    public static void makeRobotMove() {
        boolean tryAgain = true;
        System.out.println("Making move level \"easy\"");
        while (tryAgain) {
            robot.setNewCell();
            game.setNewCell(robot.cellY, robot.cellX);
            tryAgain = game.isCellOccupied();
        }
    }

    public static void getNewGameState() {
        game.setCoordinates();
        game.printMatrix();
        game.getGameState();
    }

    public static void main(String[] args) {
        game = new TicTacToe();
        player = new Player();
        robot = new Robot();

        game.setEmptyGameMatrix();
        game.printMatrix();

        while (!game.finished) {
            if (game.moves % 2 == 0) {
                makePlayerMove();
            } else {
                makeRobotMove();
            }

            getNewGameState();
        }
    }
}
