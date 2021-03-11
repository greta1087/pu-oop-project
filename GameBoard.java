package game;

import javax.swing.*;

public class GameBoard extends JFrame {

    GameBoard(){

        this.add(new GamePanel());
        this.setTitle("Knights, Elves & Dwarfs");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

}
