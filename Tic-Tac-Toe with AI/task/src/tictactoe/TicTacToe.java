package tictactoe;

import java.util.Arrays;

public class TicTacToe {
    public char[][] gameMatrix = new char[3][3];
    public int moves = 0;
    public int[][][] fieldMap = new int[][][]{{{1, 1}, {1, 2}, {1, 3}}, {{2, 1}, {2, 2}, {2, 3}}, {{3, 1}, {3, 2}, {3, 3}}};
    public int newCellY = 0;
    public int newCellX = 0;
    public boolean finished = false;

    public void setEmptyGameMatrix() {
        for (char[] row :
                gameMatrix) {
            Arrays.fill(row, ' ');
        }

    }

    public void printMatrix() {
        System.out.println("---------");
        for (char[] row : gameMatrix) {
            System.out.print("| ");
            for (int j = 0; j < gameMatrix.length; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }

    public boolean isCellOccupied() {
        return gameMatrix[newCellY][newCellX] != ' ';
    }

    public void setNewCell(int y, int x) {
        for (int i = 0; i < fieldMap.length; i++) {
            for (int j = 0; j < fieldMap.length; j++) {
                if (fieldMap[i][j][0] == y && fieldMap[i][j][1] == x) {
                    if (gameMatrix[i][j] == ' ') {
                        newCellY = i;
                        newCellX = j;
                    }
                    break;
                }
            }
        }
    }

    public void setCoordinates() {
        gameMatrix[newCellY][newCellX] = ((moves % 2) == 0) ? 'X' : 'O';
        moves++;
    }

    public void getGameState() {
        // find winning line
        if ((gameMatrix[0][0] == gameMatrix[0][1]
                && gameMatrix[0][0] == gameMatrix[0][2]
                && (gameMatrix[0][0] == 'X' || gameMatrix[0][0] == 'O'))
                ^ (gameMatrix[1][0] == gameMatrix[1][1]
                && gameMatrix[1][0] == gameMatrix[1][2]
                && (gameMatrix[1][0] == 'X' || gameMatrix[1][0] == 'O'))
                ^ (gameMatrix[2][0] == gameMatrix[2][1]
                && gameMatrix[2][0] == gameMatrix[2][2]
                && (gameMatrix[2][0] == 'X' || gameMatrix[2][0] == 'O'))
                ^ (gameMatrix[0][0] == gameMatrix[1][0]
                && gameMatrix[0][0] == gameMatrix[2][0]
                && (gameMatrix[0][0] == 'X' || gameMatrix[0][0] == 'O'))
                ^ (gameMatrix[0][1] == gameMatrix[1][1]
                && gameMatrix[0][1] == gameMatrix[2][1]
                && (gameMatrix[0][1] == 'X' || gameMatrix[0][1] == 'O'))
                ^ (gameMatrix[0][2] == gameMatrix[1][2]
                && gameMatrix[0][2] == gameMatrix[2][2]
                && (gameMatrix[0][2] == 'X' || gameMatrix[0][2] == 'O'))
                ^ (gameMatrix[0][0] == gameMatrix[1][1]
                && gameMatrix[0][0] == gameMatrix[2][2]
                && (gameMatrix[0][0] == 'X' || gameMatrix[0][0] == 'O'))
                ^ (gameMatrix[0][2] == gameMatrix[1][1]
                && gameMatrix[1][1] == gameMatrix[2][0]
                && (gameMatrix[0][2] == 'X' || gameMatrix[0][2] == 'O'))
        ) {
            String winner = (moves % 2 == 0) ? "O" : "X";
            System.out.printf("%s wins%n", winner);
            finished = true;
            return;
        }

        // check for empty cells
        for (char[] row :
                gameMatrix) {
            for (char cell :
                    row) {
                if (cell == ' ') {
                    // System.out.println("Game not finished");
                    return;
                }
            }
        }

        // print draw if no win and no empty cells
        System.out.println("Draw");
        finished = true;
    }
}
