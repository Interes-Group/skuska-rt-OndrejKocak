package sk.stuba.fei.uim.oop.window;

import sk.stuba.fei.uim.oop.shapes.Line;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {
    private final List<Line> lines;
    public Canvas(){
        this.lines = new ArrayList<>();
    }

    public void createLines(List<Point> points){
        List<Point> pointsCopy = new ArrayList<>(points);
        this.lines.clear();
        Point start = pointsCopy.remove(0);
        for(Point point : points){
            lines.add(new Line(start.x,point.x,start.y,point.y));
            start = point;
        }
    }

    @Override
    public void paintComponent(Graphics g){
        for(Line line : lines){
            line.draw(g);
        }
    }
}
