package tictactoe;

import java.util.Scanner;

public class Player {
    public Scanner sc = new Scanner(System.in);
    public int cellY;
    public int cellX;
    public boolean correctInput;

    public void getCoordinates() {
        System.out.print("Enter the coordinates: ");
        String[] inputs = sc.nextLine().split(" ");

        correctInput = hasCorrectInput(inputs);
         if (correctInput) {
             cellY = Integer.parseInt(inputs[0]);
             cellX = Integer.parseInt(inputs[1]);
         }
    }

    public boolean hasCorrectInput(String[] inputs) {
        if (inputs.length != 2 || !areIntegers(inputs)) {
            System.out.println("You should enter numbers!");
            return false;
        }

        int y = Integer.parseInt(inputs[0]);
        int x = Integer.parseInt(inputs[1]);
        if (y < 1 || y > 3 || x < 1 || x > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        return true;
    }

    public boolean areIntegers(String[] strings) {
        for (String str :
                strings) {
            if (str == null) {
                return false;
            }
            try {
                Integer.parseInt(str);
            } catch (NumberFormatException nfe) {
                return false;
            }
        }
        return true;
    }
}
