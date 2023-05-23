package sk.stuba.fei.uim.oop.shapes;

import java.awt.*;

public class HourGlass extends Shape{
    public HourGlass(int posX, int posY, int radius, Color color) {
        super(posX, posY, radius, color);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillPolygon(new int[]{posX-radius, posX, posX+radius}, new int[]{posY-radius, posY, posY-radius}, 3);
        g.fillPolygon(new int[]{posX-radius, posX, posX+radius}, new int[]{posY+radius, posY, posY+radius}, 3);
    }
}
