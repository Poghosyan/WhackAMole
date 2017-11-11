import java.util.Arrays;
import java.util.Random;

public class WhackAMole {
    private final int TOTAL_MOLES = 10;
    public int score, molesLeft, attempts;
    private char [][] moleGrid;

    WhackAMole(int numAttempts, int gridDimension) {
        score = 0;
        this.attempts = numAttempts;
        moleGrid = new char[gridDimension][gridDimension];

        //Populate Grid
        for (int i = 0; i < moleGrid.length; ++i) {
            for (int j = 0; j < moleGrid.length; ++j) {
                moleGrid[i][j] = '*';
            }
        }

        //Populate Moles
        int molesPut = 0;
        Random rn = new Random();
        while (molesPut != TOTAL_MOLES) {
            if (place(rn.nextInt(10), rn.nextInt(10))) {
                molesPut++;
            }
        }

    }

    /**
     * Given a location, place a mole at that location. Return true if you can.
     */
    private boolean place(int x, int y) {
        if (moleGrid[x][y] != 'M') {
            moleGrid[x][y] = 'M';
            return true;
        }
        return false;
    }

    /**
     * Given a location, take a whack at that location.
     * If that location contains a mole, the score and molesLeft is updated.
     * If that location does not contain a mole, the number of attempts goes up.
     * @param x coordinate on 2d grid
     * @param y coordiante on 2d grid
     * @return true if a mole is at the position on the grid
     */
    public boolean whack(int x, int y) {
        attempts--;

        if (moleGrid[x - 1][y - 1] == 'M') {
            molesLeft--;
            moleGrid[x - 1][y - 1] = 'W';
            return true;
        } else if (moleGrid[x - 1][y - 1] == 'W') {
            return true;
        }

        return false;
    }

    /**
     * Print the grid without showing where the moles are.
     * For every spot that has recorded a “whacked mole,” print out a W, or * otherwise.
     */
    public void printGridtoUser() {
        for (int i = 0; i < moleGrid.length; ++i) {
            for (int j = 0; j < moleGrid.length; ++j) {
                if (moleGrid[i][j] == 'M') {
                    System.out.print(" * ");
                } else {
                    System.out.print(" " + moleGrid[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     *  Print the grid completely. This is effectively dumping the 2d array on the screen.
     *  The places where the moles are should be printed as an ‘M’. The places where the
     *  moles have been whacked should be printed as a ‘W’. The places that don’t have a
     *  mole should be printed as *.
     */
    public void printGrid() {
        for (char[] ch : moleGrid) {
            System.out.println(Arrays.toString(ch));
        }
    }

    public boolean gameOver() {
        return attempts == 0;
    }
}
