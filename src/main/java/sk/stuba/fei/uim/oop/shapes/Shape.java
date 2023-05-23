package sk.stuba.fei.uim.oop.shapes;

import java.awt.*;

public abstract class Shape {
    protected int posX;
    protected int posY;
    protected int radius;
    private final Color color;

    public Shape(int posX, int posY,int radius, Color color) {
        this.posX = posX;
        this.posY = posY;
        this.color = color;
        this.radius = radius;
    }

    public void draw(Graphics g){
        g.setColor(this.color);
    }
}
