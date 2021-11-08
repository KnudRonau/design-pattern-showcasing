package com.dt181g.project;

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


        addElements(west, new GridLayout(5, 2, 20, 20), 8, 1);
        addTemplateButtons(west);
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

    public static void addElements(JPanel panel, LayoutManager mgr, int amount, int type) {
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

    public void addTemplateButtons(JPanel panel) {
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
