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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
