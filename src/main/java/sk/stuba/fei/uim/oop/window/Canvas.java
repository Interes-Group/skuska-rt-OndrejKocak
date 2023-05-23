package sk.stuba.fei.uim.oop.window;

import sk.stuba.fei.uim.oop.logic.Mode;
import sk.stuba.fei.uim.oop.shapes.*;
import sk.stuba.fei.uim.oop.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {
    private final List<Line> lines;

    private final List<Shape> shapes;
    public Canvas(){
        this.lines = new ArrayList<>();
        this.shapes = new ArrayList<>();
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

    public void createShapes(List<Point> points,int spacing, int radius, Color color, Mode mode){
        int count = 0;
        this.shapes.clear();
        for(Point point : points){
            if((count % spacing == 0) || count == points.size()-1){
                if(mode.equals(Mode.SQUARE)){
                    this.shapes.add(new Square(point.x, point.y, radius, color));
                }
               else if(mode.equals(Mode.CIRCLE)){
                    this.shapes.add(new Circle(point.x, point.y, radius, color));
               }
               else if(mode.equals(Mode.HOURGLASS)){
                    this.shapes.add(new HourGlass(point.x, point.y, radius, color));
               }
            }
            count++;
        }
    }

    @Override
    public void paintComponent(Graphics g){
        for(Line line : lines){
            line.draw(g);
        }
        for(Shape shape : shapes){
            shape.draw(g);
        }
    }
}
