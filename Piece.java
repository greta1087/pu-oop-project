package piece;

import game.Tile;

import java.awt.*;

//A "blueprint" of what characteristics a game piece should have
public  abstract class Piece {

    protected int row;
    protected int col;
    protected Color color;
    protected String id;
    protected int attack;
    protected int shield;
    protected int health;
    protected int attackRange;
    protected int speed;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void render(Graphics g) {

        int x = this.col * Tile.TILE_SIZE;
        int y = this.row * Tile.TILE_SIZE;

        g.setColor(this.color);
        g.fillRect(x, y, 50, 50);

        g.setColor(Color.BLACK);
        g.drawString(this.id, x + 25, y + 25);
    }

}
