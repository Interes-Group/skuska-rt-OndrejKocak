package sk.stuba.fei.uim.oop.shapes;

import java.awt.*;

public class Circle extends Shape{
    public Circle(int posX, int posY, int radius, Color color) {
        super(posX, posY, radius, color);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillOval(this.posX-radius, this.posY-radius, radius*2, radius*2);
    }
}
