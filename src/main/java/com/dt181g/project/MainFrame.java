package com.dt181g.project;

import com.dt181g.project.abstractFactory.DanishFactory;
import com.dt181g.project.abstractFactory.SwedishFactory;
import com.dt181g.project.factoryMethod.GetAnnouncementFactory;
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
    private JPanel south;
    private JTextArea center;
    private RadioShow radioShow;
    private GetAnnouncementFactory factory;
    private DanishFactory danishToyFactory;
    private SwedishFactory swedishToyFactory;

    public MainFrame() {

        instantiatePanels();

//        addElements(east, new BoxLayout(east, BoxLayout.Y_AXIS), 10, 2);
        setupLabels(east, new GridLayout(5, 2, 20, 20), 6);
        add(east, BorderLayout.EAST);


        setupLabels(north, new FlowLayout(FlowLayout.CENTER, 20, 20), 6);
        add(north, BorderLayout.NORTH);


//        addElements(west, new GridLayout(5, 2, 20, 20), 6, 1);
        setupButtons(west);
        addWelcomeMessageButton(west);
        addTemplateButtons(west);
        addObserverButton(west);


        add(west, BorderLayout.WEST);

        setupCenterText(center);
        add(center, BorderLayout.CENTER);

        setupTextField(south);
        add(south, BorderLayout.SOUTH);
//        south.add

        pack();
    }

    private void setupLabels(JPanel panel, LayoutManager mgr, int amount) {
        panel.setLayout(mgr);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        for(int i = 0; i < amount; i++) {
            panel.add(new JLabel("label " + (i+1) + " in this panel"));
        }
    }

    private JList addList() {
        String[] numbers = {"List Item One", "List Item Two", "List Item Three", "List Item Four", "List Item Five",
                "List Item Six"};
        JList<String> list = new JList<>(numbers);
        return list;
    }

    private void setupTextField(JPanel panel) {
//        panel.setLayout(new CardLayout(10, 10));
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setSize(new Dimension(300, 100));
        panel.add(new JLabel("Get an announcement! Try 'Closing', 'Sale' or 'Warning' - " +
                "Below you can enter a super secret password"), BorderLayout.NORTH);
        var textField = new JTextField("Write here!", 30);
        textField.addActionListener(event -> {
            factory = new GetAnnouncementFactory();
            if(factory.getAnnouncement(textField.getText()) != null) {
                center.append(factory.getAnnouncement(textField.getText()).getMessage());
            }
            textField.setText("");
        });
        panel.add(textField, BorderLayout.CENTER);
        panel.add(addList(), BorderLayout.EAST);
        panel.add(addPasswordField(), BorderLayout.SOUTH);

    }

    private JPasswordField addPasswordField() {
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.addActionListener(event -> {
            center.append(new String(passwordField.getPassword()) + "\n");
            passwordField.setText("");
        });
        return passwordField;
    }

    private void addWelcomeMessageButton(JPanel panel) {
        JButton welcomeButton = new JButton("Get Welcome Message");
        welcomeButton.addActionListener(event ->
                setWelcomeText());
        panel.add(welcomeButton);
    }

    private void setupCenterText(JTextArea textArea) {
        setWelcomeText();
        textArea.setColumns(100);
        textArea.setFont(new Font("calibri", 1, 16));
        textArea.setEditable(false);
    }

    private void setupButtons(JPanel panel) {
//        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setBorder(new EmptyBorder(10,10,10,10));

    }

    private void setWelcomeText() {
        center.setText("Welcome to the mainframe! This frame is manages using BorderLayout.\n\n" +
                "Look up and see JLabels managed by a FlowLayout\n" +
                "Look to your right and see JLabels managed by a BoxLayout\n" +
                "Look to your left and see JButtons managed by a GridLayout.\n");
    }

    private void addObserverButton(JPanel panel) {
        this.radioShow = new RadioShow();
        RadioUnit radio1 = new RadioUnit("Transistor Radio");
        RadioUnit radio2 = new RadioUnit("Car Radio");
        RadioUnit radio3 = new RadioUnit("SmartPhone");
        radio1.followObservable(radioShow);
        radio2.followObservable(radioShow);
        radio3.followObservable(radioShow);
        radioShow.addObserver(radio1);
        radioShow.addObserver(radio2);
        radioShow.addObserver(radio3);

        var button = new JButton("Do a radio broadcast!");
        panel.add(button);
        button.addActionListener(event ->
                radioShow.doBroadcast());

    }

    private void addTemplateButtons(JPanel panel) {
        TemplateDemo sub1 = new Sub1();
        TemplateDemo sub2 = new Sub2();
        var button1 = new JButton("Template button 1");
        panel.add(button1);
        button1.addActionListener(event ->
                center.setText(sub1.outputInfo()));

        var button2 = new JButton("Template button 2");
        panel.add(button2);
        button2.addActionListener(event ->
                center.setText(sub2.outputInfo()));
    }

    private void instantiatePanels() {
        east = new JPanel();
        north = new JPanel();
        west = new JPanel();
        center = new JTextArea();
        south = new JPanel();
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
