package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

//All the components of the application
public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 975;
    static final int SCREEN_HEIGHT = 525;
    int yourScore;
    int opponentScore;
    int rounds;
    int yourDestroyedPieces;
    int opponentDestroyedPieces;
    int healthRestored;
    int secondChanceMove;
    boolean gameRunning = true;

    Random random;

    GamePanel(){

        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setFocusable(true);

    }

    //Renders the components on the frame
    @Override
    public void paint(Graphics g) {

        if(gameRunning) {
            for (int row = 0; row < 7; row++) {
                for (int col = 0; col < 9; col++) {

                    this.renderGameTile(g, row, col);

                }
            }
        } else {
            gameOver(g);
        }
    }

    //Sets the color of the game board tiles
    public Color getTileColor(int row, int col) {

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

    //Renders the tiles
    public void renderGameTile(Graphics g, int row, int col) {

        Color tileColor = this.getTileColor(row, col);
        Tile tile = new Tile(row, col, tileColor);
        tile.render(g);
    }

    public void healing () {

        healthRestored = random.nextInt(6);
        //pieceHealth += healthRestored

        secondChanceMove = random.nextInt(6);

        if(!(secondChanceMove % 2 == 0)) {
            //The player can make a move again
        }
    }
    

    //Renders game over screen
    public void gameOver(Graphics g) {

        //Game Over text
        g.setColor(Color.BLACK);
        g.setFont( new Font("Comic Sans MS",Font.PLAIN, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("The game is over!", (SCREEN_WIDTH - metrics1.stringWidth("The game is over!"))/2,  100);
        //Score
        g.setFont( new Font("Comic Sans MS",Font.PLAIN, 25));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Your score: " + yourScore, (SCREEN_WIDTH - metrics2.stringWidth("Your score: "))/2, 200);
        FontMetrics metrics3 = getFontMetrics(g.getFont());
        g.drawString("Your opponent's score: " + opponentScore, (SCREEN_WIDTH - metrics3.stringWidth("Your opponent's score: "))/2, 240);
        //Number of rounds
        FontMetrics metrics4 = getFontMetrics(g.getFont());
        g.drawString("Number of rounds: " + rounds, (SCREEN_WIDTH - metrics4.stringWidth("Number of rounds: "))/2, 280);
        //All destroyed pieces
        FontMetrics metrics5 = getFontMetrics(g.getFont());
        g.drawString("Number of your destroyed pieces: " + yourDestroyedPieces, (SCREEN_WIDTH - metrics5.stringWidth("Number of your destroyed pieces: "))/2, 320);
        FontMetrics metrics6 = getFontMetrics(g.getFont());
        g.drawString("Number of your opponent's destroyed pieces: " + opponentDestroyedPieces, (SCREEN_WIDTH - metrics6.stringWidth("Number of your opponent's destroyed pieces: "))/2, 360);

    }

    //Checks if the game is over
    public void checkGameEnd() {

        // if () { gameRunning = false; }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(gameRunning) {

            checkGameEnd();
        }
        repaint();
    }

    }

