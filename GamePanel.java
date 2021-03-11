package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GamePanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 975;
    static final int SCREEN_HEIGHT = 525;

    GamePanel(){

        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setFocusable(true);

    }

    @Override
    public void paint(Graphics g) {

        for(int row = 0; row < 7; row++) {
            for(int col = 0; col < 9; col++) {

                this.renderGameTile(g, row, col);

            }
        }

    }

    private Color getTileColor(int row, int col) {

        boolean isRowEven = (row % 2 == 0);
        boolean isRowOdd = !isRowEven;
        boolean isColEven = (col % 2 == 0);
        boolean isColOdd = !isColEven;


      if (!(row == 2) && !(row == 3) && !(row == 4)) {
            if (isRowEven && isColEven) return Color.GRAY;
            if (isRowEven && isColOdd) return Color.DARK_GRAY;
            if (isRowOdd && isColEven) return Color.DARK_GRAY;
            if (isRowOdd && isColOdd) return Color.GRAY;
            }
        return Color.LIGHT_GRAY;
    }


    private void renderGameTile(Graphics g, int row, int col) {

        Color tileColor = this.getTileColor(row, col);
        Tile tile = new Tile(row, col, tileColor);
        tile.render(g);
    }

    private void gameOver(Graphics g) {

        //Game Over text
        g.setColor(Color.BLACK);
        g.setFont( new Font("Comic Sans MS",Font.PLAIN, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("The game is over!", (SCREEN_WIDTH - metrics1.stringWidth("The game is over!"))/2,  100);
        //Score
        g.setFont( new Font("Comic Sans MS",Font.PLAIN, 25));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Your score: ", (SCREEN_WIDTH - metrics2.stringWidth("Your score: "))/2, 200);
        FontMetrics metrics3 = getFontMetrics(g.getFont());
        g.drawString("Your opponent's score: ", (SCREEN_WIDTH - metrics3.stringWidth("Your opponent's score: "))/2, 240);
        //Number of rounds
        FontMetrics metrics4 = getFontMetrics(g.getFont());
        g.drawString("Number of rounds: ", (SCREEN_WIDTH - metrics4.stringWidth("Number of rounds: "))/2, 280);
        //All destroyed pieces
        FontMetrics metrics5 = getFontMetrics(g.getFont());
        g.drawString("Number of your destroyed pieces: ", (SCREEN_WIDTH - metrics5.stringWidth("Number of your destroyed pieces: "))/2, 320);
        FontMetrics metrics6 = getFontMetrics(g.getFont());
        g.drawString("Number of your opponent's destroyed pieces: ", (SCREEN_WIDTH - metrics6.stringWidth("Number of your opponent's destroyed pieces: "))/2, 360);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
