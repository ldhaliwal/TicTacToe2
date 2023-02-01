import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;

    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;

    private final int INCREMENT_WIDTH = WINDOW_HEIGHT / 5;
    private boolean isWinningSquare;

    private TicTacToeViewer window;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer window) {
        this.row = row;
        this.col = col;

        this.window = window;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;

    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    public void draw(Graphics g) {

        //TODO: display winner message
        int x = INCREMENT_WIDTH * (row + 1);
        int y = INCREMENT_WIDTH * (col + 1);

        //TODO: draw numbers
        drawAxes(g);

        if(marker.equals("X")){
            Image i = window.getXImage();
            g.drawImage(i, x, y, window);
        }
        else if (marker.equals("O")) {
            Image i = window.getOImage();
            g.drawImage(i, x, y, window);
        }

        g.setColor(Color.BLACK);
        g.drawRect(x, y, INCREMENT_WIDTH, INCREMENT_WIDTH);

        if(this.isWinningSquare){
            g.setColor(Color.green);
            g.fillRect(x, y, INCREMENT_WIDTH, INCREMENT_WIDTH);
        }
    }

    public void drawAxes(Graphics g) {
        for (int i = 0; i < 3; i++) {
            String number = i + "";
            g.drawString(number, (INCREMENT_WIDTH / 2) + (INCREMENT_WIDTH * (i + 1)), INCREMENT_WIDTH/2);
        }

        for (int i = 0; i < 3; i++) {
            String number = i + "";
            g.drawString(number, INCREMENT_WIDTH/2, (INCREMENT_WIDTH / 2) + (INCREMENT_WIDTH * (i + 1)));
        }
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }
}
