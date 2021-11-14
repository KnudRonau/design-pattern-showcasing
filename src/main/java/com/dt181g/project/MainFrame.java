package com.dt181g.project;

import com.dt181g.project.abstractFactory.DanishFactory;
import com.dt181g.project.abstractFactory.SwedishFactory;
import com.dt181g.project.factoryMethod.GetAnnouncementFactory;
import com.dt181g.project.observer.RadioShow;
import com.dt181g.project.observer.RadioUnit;
import com.dt181g.project.streams.PersonFilter;
import com.dt181g.project.templateMethod.Sub1;
import com.dt181g.project.templateMethod.Sub2;
import com.dt181g.project.templateMethod.TemplateDemo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 1200;
    private static final int DEFAULT_HEIGHT = 800;
    private JPanel east;
    private JPanel north;
    private JPanel west;
    private JPanel south;
    private JTextArea center;
    private JScrollPane centerScrollPane;
    private RadioShow radioShow;
    private GetAnnouncementFactory factory;
    private DanishFactory danishFactory;
    private SwedishFactory swedishFactory;
    private PersonFilter personFilter;

    public MainFrame() {

        instantiatePanels();

        setupLabels(east, new GridLayout(5, 2, 20, 20), 6);
        add(east, BorderLayout.EAST);

        setupLabels(north, new FlowLayout(FlowLayout.CENTER, 20, 20), 6);
        add(north, BorderLayout.NORTH);

        setupButtons(west);
        add(west, BorderLayout.WEST);

        setupCenterText(center);
        add(centerScrollPane, BorderLayout.CENTER);

        setupTextField(south);
        add(south, BorderLayout.SOUTH);

        pack();
    }


    private void addPersonFilterButtons(JPanel panel) {
        personFilter = new PersonFilter();
        JButton allPeople = new JButton("Click to see all people!");
        JButton filterMillionaire = new JButton("See Millionaires");
        JButton nameSort = new JButton("Sort by name");
        JButton oldest = new JButton("Reveal the oldest person");
        JButton married = new JButton("See all the married folks");

        allPeople.addActionListener(event -> center.setText(personFilter.getPeople()));
        filterMillionaire.addActionListener(event -> center.setText(personFilter.getMillionaires()));
        nameSort.addActionListener(event -> center.setText(personFilter.getSortedNames()));
        oldest.addActionListener(event -> center.setText(personFilter.getOldest()));
        married.addActionListener(event -> center.setText(personFilter.getMarried()));

        panel.add(allPeople);
        panel.add(filterMillionaire);
        panel.add(nameSort);
        panel.add(oldest);
        panel.add(married);

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
        return new JList<>(numbers);
    }

    private void setupTextField(JPanel panel) {
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setSize(new Dimension(300, 100));
        panel.add(new JLabel("Get an announcement! Try 'Closing', 'Sale' or 'Warning' - " +
                "Below you can enter a super secret password"), BorderLayout.NORTH);
        var textField = new JTextField("Write here!", 30);
        factory = new GetAnnouncementFactory();
        textField.addActionListener(event -> {
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
        textArea.setFont(new Font("calibri", Font.BOLD, 16));
        textArea.setEditable(false);
        centerScrollPane = new JScrollPane(textArea);

    }

    private void setupButtons(JPanel panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(10,10,10,10));

        addWelcomeMessageButton(panel);

        panel.add(new JLabel("Buttons for showcasing Template Method"));
        addTemplateButtons(panel);

        panel.add(new JLabel("Button for showcasing Observer Pattern"));
        addObserverButton(panel);

        panel.add(new JLabel("Buttons for showcasing Abstract Factory Pattern"));
        addAbstractButtons(panel);

        panel.add(new JLabel("Buttons for showcasing use of Streams"));
        addPersonFilterButtons(panel);

    }

    private void addAbstractButtons(JPanel panel) {
        danishFactory = new DanishFactory();
        swedishFactory = new SwedishFactory();
        JButton danishSofa = new JButton("Get a Danish Sofa!");
        JButton swedishSofa = new JButton("Get a Swedish Sofa!");
        JButton danishToy = new JButton("Get a Danish Toy!");
        JButton swedishToy = new JButton("Get Swedish Toy!");

        danishSofa.addActionListener(event ->
                center.append("\n" + danishFactory.createSofa().getInfo()));
        swedishSofa.addActionListener(event ->
                center.append("\n" + swedishFactory.createSofa().getInfo()));
        danishToy.addActionListener(event ->
                center.append("\n" + danishFactory.createToy().getInfo()));
        swedishToy.addActionListener(event ->
                center.append("\n" + swedishFactory.createToy().getInfo()));

        panel.add(danishSofa);
        panel.add(swedishSofa);
        panel.add(danishToy);
        panel.add(swedishToy);

    }

    private void setWelcomeText() {
        center.setText("""
                Welcome to the mainframe! This frame is managed using BorderLayout.

                Look up and see JLabels managed by a FlowLayout
                Look to your right and see JLabels managed by a GridLayout
                Look to your left and see JButtons managed by a BoxLayout.
                Try the buttons! They do all sorts of cool stuff.
                Look down to see a TextField and a PasswordField. Get an Announcement from the first!
                But be careful with the latter. Your password might not be as safe as you'd hope.""");
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
