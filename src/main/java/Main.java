import java.util.Scanner;

/**
 * Begin by creating a 10 by 10 grid where you randomly place the moles. Place a total of 10 moles.
 * Now allow the user (remember how to use Scanner?) to enter the x and y coordinates of where they
 * would like to take a whack. Tell them they have a maximum of 50 attempts to get all the moles.
 * At any point in the game, they can input coordinates of -1, -1 in order to indicate that they
 * are giving up. If the user gives up they get to see the entire grid.
 */

public class Main {
    public static void main(String[] args) {
        final int ALLOWED_ATTEMPTS = 50;
        final int DIMENSIONS = 10;
        WhackAMole game = new WhackAMole(ALLOWED_ATTEMPTS, DIMENSIONS);

        Scanner input = new Scanner(System.in);
        int x = 0, y = 0;

        while(!game.gameOver() && x != -1 && y != -1) {
            System.out.println("You have " + game.attempts +" attempts to get all moles.");

            System.out.println("Please pick X coordinate.");
            x = input.nextInt();

            System.out.println("Please pick Y coordinate.");
            y = input.nextInt();

            if(x != -1 && y != -1) {
                game.whack(x, y);
                game.printGridtoUser();
            }
        }

        if (game.gameOver() || x != -1 || y != -1) {
            game.printGrid();
        }
    }
}
