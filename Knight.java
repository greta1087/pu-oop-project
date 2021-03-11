package piece;
import java.awt.*;

public class Knight extends Piece {

    public Knight(int row, int col, Color color) {

        this.row = row;
        this.col = col;
        this.color = color;
        this.id = "K";
        this.attack = 8;
        this.shield = 3;
        this.health = 15;
        this.attackRange = 1;
        this.speed = 1;

    }

}
