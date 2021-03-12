package game;

import java.awt.*;

//Creates the obstacles
public class Obstacle {

        public static final int OBSTACLE_SIZE = 75;

        private int row;
        private int col;

        public Obstacle(int row, int col) {

            this.row = row;
            this.col = col;

        }

        public void render(Graphics g) {

            int tileX = this.col * OBSTACLE_SIZE;
            int tileY = this.row * OBSTACLE_SIZE;

            g.setColor(Color.BLACK);
            g.fillRect(tileX, tileY, OBSTACLE_SIZE, OBSTACLE_SIZE);
            g.setColor(Color.BLACK);
            g.drawRect(tileX, tileY, OBSTACLE_SIZE, OBSTACLE_SIZE);
        }

}
