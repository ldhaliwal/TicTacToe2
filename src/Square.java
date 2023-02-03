import java.awt.*;
import javax.swing.*;

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

    private final int WIN_MESSAGE_Y = 750;
    private final int INCREMENT_WIDTH = WINDOW_HEIGHT / 5;
    private boolean isWinningSquare;

    private boolean tie;

    private Image xImage;
    private Image oImage;

    private TicTacToeViewer window;

    private TicTacToe game;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer window, TicTacToe game) {
        this.row = row;
        this.col = col;

        this.game = game;
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
        int x = INCREMENT_WIDTH * (col + 1);
        int y = INCREMENT_WIDTH * (row + 1);

        //draw numbers
        drawAxes(g);

        g.setColor(Color.BLACK);
        g.drawRect(x, y, INCREMENT_WIDTH, INCREMENT_WIDTH);

        if(this.isWinningSquare){
            g.setColor(Color.green);
            g.fillRect(x, y, INCREMENT_WIDTH, INCREMENT_WIDTH);

            g.setColor(Color.RED);
            g.setFont(new Font("Serif", Font.BOLD, 50));
            if(marker.equals(TicTacToe.X_MARKER)){
                g.drawString("X Wins!", WINDOW_HEIGHT/2, WIN_MESSAGE_Y);
            }
            else if (marker.equals(TicTacToe.O_MARKER)) {
                g.drawString("O Wins!", WINDOW_HEIGHT/2, WIN_MESSAGE_Y);
            }
        }

        if(game.checkTie()){
            g.setColor(Color.RED);
            g.setFont(new Font("Serif", Font.BOLD, 50));

            g.drawString("Game ends in a tie!", INCREMENT_WIDTH, WIN_MESSAGE_Y);
        }

        if(marker.equals(TicTacToe.X_MARKER)){
            xImage = new ImageIcon("Resources/X.png").getImage();
            g.drawImage(xImage, x, y, INCREMENT_WIDTH, INCREMENT_WIDTH, window);
        }
        else if (marker.equals(TicTacToe.O_MARKER)) {
            oImage = new ImageIcon("Resources/O.png").getImage();
            g.drawImage(oImage, x, y, INCREMENT_WIDTH, INCREMENT_WIDTH, window);
        }
    }

    public void drawAxes(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Serif", Font.BOLD, 10));

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
