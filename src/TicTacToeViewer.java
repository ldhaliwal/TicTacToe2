import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;


public class TicTacToeViewer extends JFrame{
    // TODO: Complete this class

    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;
    private Image oImage;
    private Image xImage;

    Square [][] board;
    public TicTacToeViewer(Square[][] board){
        oImage = new ImageIcon("Resources/O.png").getImage();
        xImage = new ImageIcon("Resources/X.png").getImage();

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

    public Image getOImage() {
        return oImage;
    }

    public Image getXImage() {
        return xImage;
    }
}
