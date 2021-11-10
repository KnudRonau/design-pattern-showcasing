package com.dt181g.project;

import com.dt181g.project.observer.RadioShow;
import com.dt181g.project.observer.RadioUnit;
import com.dt181g.project.templateMethod.Sub1;
import com.dt181g.project.templateMethod.Sub2;
import com.dt181g.project.templateMethod.TemplateDemo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 1200;
    private static final int DEFAULT_HEIGHT = 800;
    private JPanel contentpane;
    private JPanel east;
    private JPanel north;
    private JPanel west;
    private JTextArea center;
    private RadioShow radioShow;

    public MainFrame() {
//        contentpane = new JPanel();
//        contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        contentpane.setLayout(new BorderLayout());
//        setContentPane(contentpane);
        east = new JPanel();
        north = new JPanel();
        west = new JPanel();
        center = new JTextArea();

        addElements(east, new BoxLayout(east, BoxLayout.Y_AXIS), 10, 2);
        add(east, BorderLayout.EAST);


        addElements(north, new FlowLayout(FlowLayout.CENTER, 20, 20), 5,2);
        add(north, BorderLayout.NORTH);


        addElements(west, new GridLayout(5, 2, 20, 20), 6, 1);
        addTemplateButtons(west);
        addObserverButton(west);
        add(west, BorderLayout.WEST);

        center.setText("Welcome to the mainframe! This frame is manages using BorderLayout.\n\n" +
                "Look up and see JLabels managed by a FlowLayout\n" +
                "Look to your right and see JLabels managed by a BoxLayout\n" +
                "Look to your left and see JButtons managed by a GridLayout.");
        center.setColumns(100);
        center.setFont(new Font("calibri", 1, 20));
        center.setEditable(false);
        add(center, BorderLayout.CENTER);
        pack();
    }

    private static void addElements(JPanel panel, LayoutManager mgr, int amount, int type) {
        panel.setLayout(mgr);
        panel.setBorder(new EmptyBorder(10,10,10,10));
        for(int i = 0; i < amount; i++) {
            if(type == 1) {
                panel.add(new JButton("This is button number " + (i+1)));
            } else {
                panel.add(new JLabel("This is label number " + (i+1)));
            }

        }

    }

    private void addObserverButton(JPanel panel) {
        this.radioShow = new RadioShow();
        RadioUnit radio1 = new RadioUnit("Transistor Radio");
        RadioUnit radio2 = new RadioUnit("Car Radio");
        RadioUnit radio3 = new RadioUnit("SmartPhone");
        radio1.followRadioShow(radioShow);
        radio2.followRadioShow(radioShow);
        radio3.followRadioShow(radioShow);
        radioShow.addRadioUnit(radio1);
        radioShow.addRadioUnit(radio2);
        radioShow.addRadioUnit(radio3);

        var button = new JButton("Do a radio broadcast!");
        panel.add(button);
        button.addActionListener(event ->
                radioShow.doBroadcast());

    }

    private void addTemplateButtons(JPanel panel) {
        TemplateDemo sub1 = new Sub1();
        TemplateDemo sub2 = new Sub2();
        var button1 = new JButton("SubClass 1 button");
        panel.add(button1);
        button1.addActionListener(event ->
                center.setText(sub1.outputInfo()));

        var button2 = new JButton("SubClass 2 button");
        panel.add(button2);
        button2.addActionListener(event ->
                center.setText(sub2.outputInfo()));
    }


    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
