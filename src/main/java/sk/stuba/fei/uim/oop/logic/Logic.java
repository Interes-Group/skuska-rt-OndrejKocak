package sk.stuba.fei.uim.oop.logic;

import lombok.Getter;
import sk.stuba.fei.uim.oop.window.Canvas;
import sk.stuba.fei.uim.oop.window.Window;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Logic extends UniversalAdapter{
    private final JFrame mainFrame;

    private final Window  window;

    @Getter
    private final Canvas canvas;

    @Getter
    private final JLabel leghtLabel;
    @Getter
    private final JLabel radiusLabel;
    @Getter
    private final JLabel spacingLabel;

    private int length;
    private int radius;
    private int spacing;

    private Mode mode;

    private Color color;

    private final List<Point> points;
    public Logic(Window window){
        this.mainFrame = window.getFrame();
        this.window = window;
        this.canvas = new Canvas();
        this.canvas.addMouseMotionListener(this);
        this.canvas.addMouseListener(this);
        this.leghtLabel = new JLabel("Length");
        this.radiusLabel = new JLabel("Radius");
        this.spacingLabel = new JLabel("Spacing");
        this.mode = Mode.CIRCLE;
        this.points = new ArrayList<>();
        this.length = 50;
        this.radius = 5;
        this.spacing = 5;
        this.color = Color.cyan;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       JComboBox comboBox = ((JComboBox)e.getSource());
       if(comboBox == null){
           return;
       }
       if(comboBox.getSelectedItem().equals(Mode.CIRCLE.getModeName())){
           this.mode = Mode.CIRCLE;
       }
       else if(comboBox.getSelectedItem().equals(Mode.SQUARE.getModeName())){
           this.mode = Mode.SQUARE;
       }
       else if(comboBox.getSelectedItem().equals(Mode.HOURGLASS.getModeName())){
           this.mode = Mode.HOURGLASS;
       }
       canvas.createShapes(points, spacing, radius, color, mode);
       this.mainFrame.repaint();
    }

    private void removePointsAboveLength(){
        while(points.size() >= length ){
            points.remove(0);
        }

    }

    public void updateCanvas(){
        this.canvas.createLines(this.points);
        this.canvas.createShapes(this.points, this.spacing, this.radius, this.color, this.mode);
        this.mainFrame.repaint();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        if(slider.equals(window.getLengthSlider())){
            this.length = slider.getValue();
            removePointsAboveLength();
        }
        else if(slider.equals(window.getRadiusSlider())){
            this.radius = slider.getValue();
        }
        else if(slider.equals(window.getSpacingSlider())){
            this.spacing = slider.getValue();
        }
       this.updateCanvas();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.points.clear();
        this.points.add(e.getPoint());
        this.mainFrame.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
       if(this.points.size() >= this.length){
           points.remove(0);
       }
       points.add(e.getPoint());
      this.updateCanvas();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       this.mouseMoved(e);
    }
}
