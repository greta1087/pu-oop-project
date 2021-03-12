package piece;

import java.awt.*;

//Creates the dwarf piece
public class Dwarf extends  Piece {

    public Dwarf(int row, int col, Color color) {

        this.row = row;
        this.col = col;
        this.color = color;
        this.id = "D";
        this.attack = 6;
        this.shield = 2;
        this.health = 12;
        this.attackRange = 2;
        this.speed = 2;

    }
}
