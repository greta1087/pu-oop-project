package game;

import piece.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

//All the components of the application
public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 975;
    static final int SCREEN_HEIGHT = 525;
    int playerAScore;
    int playerBScore;
    int rounds;
    int playerADestroyedPieces;
    int playerBDestroyedPieces;
    int dice;
    int healthRestored;
    int secondChanceMove;
    int damageTaken;
    int attackStrength;
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
        //Score
        g.setFont( new Font("Comic Sans MS",Font.PLAIN, 15));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Player A score: " + playerAScore, 700, 20);
        FontMetrics metrics3 = getFontMetrics(g.getFont());
        g.drawString("Player B score: " + playerBScore, 700, 35);
        //Number of rounds
        FontMetrics metrics4 = getFontMetrics(g.getFont());
        g.drawString("Number of rounds: " + rounds, 700, 50);
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

    //Generates random number from 1 to 6
    public int rollDice() {

      return dice = random.nextInt(6);

    }

    //Logic for healing
    public void healing() {

        healthRestored = rollDice();
        //selectedPieceHealth += healthRestored;

        secondChanceMove = rollDice();

        if(!(secondChanceMove % 2 == 0)) {
            //The player can make a move again
        }
    }

    //Checks the damage that has been made after attacking a piece
    public void checkDamageTaken() {

        attackStrength = rollDice() + rollDice() + rollDice();

      /* if (attackStrength == 3) {
            damageTaken = (selectedPieceAttack - opponentPieceShield) / 2;
          }
          if (attackStrength == opponentPieceHealth) {
            damageTaken = 0;
          }

         damageTaken = selectedPieceAttack - opponentPieceShield

         if (player A is making the move) {
            playerAScore += damageTaken
         }
         if (player B is making the move) {
            playerBScore += damageTaken
         } */
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
        g.drawString("Player A score: " + playerAScore, (SCREEN_WIDTH - metrics2.stringWidth("Your score: "))/2, 200);
        FontMetrics metrics3 = getFontMetrics(g.getFont());
        g.drawString("Player B score: " + playerBScore, (SCREEN_WIDTH - metrics3.stringWidth("Your opponent's score: "))/2, 240);
        //Number of rounds
        FontMetrics metrics4 = getFontMetrics(g.getFont());
        g.drawString("Number of rounds: " + rounds, (SCREEN_WIDTH - metrics4.stringWidth("Number of rounds: "))/2, 280);
        //All destroyed pieces
        FontMetrics metrics5 = getFontMetrics(g.getFont());
        g.drawString("Number of player A destroyed pieces: " + playerADestroyedPieces, (SCREEN_WIDTH - metrics5.stringWidth("Number of your destroyed pieces: "))/2, 320);
        FontMetrics metrics6 = getFontMetrics(g.getFont());
        g.drawString("Number of player B destroyed pieces: " + playerBDestroyedPieces, (SCREEN_WIDTH - metrics6.stringWidth("Number of your opponent's destroyed pieces: "))/2, 360);

    }

    //Checks if the game is over
    public void checkGameEnd() {

    if (playerADestroyedPieces == 6 || playerBDestroyedPieces == 6) {
              gameRunning = false;
       }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(gameRunning) {

            checkGameEnd();
        }
        repaint();
    }

    }

