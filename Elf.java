package piece;

import java.awt.*;

public class Elf extends Piece {

    public Elf(int row, int col, Color color) {

        this.row = row;
        this.col = col;
        this.color = color;
        this.id = "E";
        this.attack = 5;
        this.shield = 1;
        this.health = 10;
        this.attackRange = 3;
        this.speed = 3;

    }

}
