package sk.stuba.fei.uim.oop.window;

import lombok.Getter;
import sk.stuba.fei.uim.oop.logic.Logic;

import javax.swing.*;
import java.awt.*;

public class Window {

    @Getter
    private final JFrame frame;
    @Getter
    private final JSlider lengthSlider;
    @Getter
    private final JSlider radiusSlider;

    @Getter
    private JSlider spacingSlider;
    public Window(){
        frame = new JFrame("Exam RT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,800);

        Logic logic = new Logic(this);

        JPanel sideMenu = new JPanel(new BorderLayout());

        JPanel labelsPanel = new JPanel(new GridLayout(1,3));
        JPanel sliderPanel = new JPanel(new GridLayout(1, 3));
        JPanel comboBoxPanel = new JPanel();

        sideMenu.setBackground(Color.GREEN);
        lengthSlider = new JSlider(20,200,50);
        lengthSlider.setOrientation(JSlider.VERTICAL);
        lengthSlider.setMajorTickSpacing(10);
        lengthSlider.setMinorTickSpacing(10);
        lengthSlider.setPaintLabels(true);
        lengthSlider.setPaintTicks(true);
        lengthSlider.setSnapToTicks(true);
        lengthSlider.setFocusable(false);
        lengthSlider.addChangeListener(logic);

        radiusSlider = new JSlider(1,20,5);
        radiusSlider.setOrientation(JSlider.VERTICAL);
        radiusSlider.setMinorTickSpacing(1);
        radiusSlider.setMajorTickSpacing(1);
        radiusSlider.setPaintLabels(true);
        radiusSlider.setPaintTicks(true);
        radiusSlider.setSnapToTicks(true);
        radiusSlider.setFocusable(false);
        radiusSlider.addChangeListener(logic);

        spacingSlider = new JSlider(1,20,5);
        spacingSlider.setOrientation(JSlider.VERTICAL);
        spacingSlider.setMajorTickSpacing(1);
        spacingSlider.setMinorTickSpacing(1);
        spacingSlider.setPaintLabels(true);
        spacingSlider.setPaintTicks(true);
        spacingSlider.setSnapToTicks(true);
        spacingSlider.setFocusable(false);
        spacingSlider.addChangeListener(logic);

        String[] shapeNames = {"Circle", "Square", "Hourglass"};
        JComboBox shapeComboBox = new JComboBox<>(shapeNames);
        shapeComboBox.setSelectedIndex(0);
        shapeComboBox.addActionListener(logic);

        labelsPanel.add(logic.getLeghtLabel());
        labelsPanel.add(logic.getRadiusLabel());
        labelsPanel.add(logic.getSpacingLabel());
        sliderPanel.add(lengthSlider);
        sliderPanel.add(radiusSlider);
        sliderPanel.add(spacingSlider);
        comboBoxPanel.add(shapeComboBox);

        sideMenu.add(labelsPanel, BorderLayout.NORTH);
        sideMenu.add(sliderPanel, BorderLayout.CENTER);
        sideMenu.add(comboBoxPanel, BorderLayout.SOUTH);

        frame.add(sideMenu, BorderLayout.EAST);
        frame.add(logic.getCanvas(), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
