import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame{

    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;

    Square [][] board;
    public TicTacToeViewer(Square[][] board){

        this.board = board;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g){
        for(Square[] s : board){
            for(Square each: s){
                each.draw(g);
            }
        }
    }
}
