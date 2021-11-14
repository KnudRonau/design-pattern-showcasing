package com.dt181g.project;

import com.dt181g.project.abstractFactory.DanishFactory;
import com.dt181g.project.abstractFactory.SwedishFactory;
import com.dt181g.project.factoryMethod.GetAnnouncementFactory;
import com.dt181g.project.observer.Observer;
import com.dt181g.project.observer.RadioShow;
import com.dt181g.project.observer.RadioUnit;
import com.dt181g.project.streams.PersonFilter;
import com.dt181g.project.templateMethod.Sub1;
import com.dt181g.project.templateMethod.Sub2;
import com.dt181g.project.templateMethod.TemplateDemo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * GUI-entity extending JFrame containing the program's graphical interface and buttons for triggering most of the
 * program's code.
 * @author Knud Ronau Larsen
 */
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

    /**
     * Constructor calling various methods to set up the GUI.
     */
    public MainFrame() {

        //Instantiates the JPanels and JTextarea
        instantiatePanels();

        //Adds labels to panels, which are managed by different LayoutManagers. Panels are added to East and North
        setupLabels(east, new GridLayout(5, 2, 20, 20), 6);
        add(east, BorderLayout.EAST);
        setupLabels(north, new FlowLayout(FlowLayout.CENTER, 20, 20), 6);
        add(north, BorderLayout.NORTH);

        //Creates and adds all the buttons to the west panel
        setupButtons(west);
        add(west, BorderLayout.WEST);

        //Adds a TextArea in a ScrollPane to center of the Frame
        setupCenterText(center);
        add(centerScrollPane, BorderLayout.CENTER);

        //Adds a TextField, PasswordField and List to south portion of the Frame
        setupTextField(south);
        add(south, BorderLayout.SOUTH);

        pack();
    }

    /**
     * Method to create buttons calling methods from the PersonFilter class. The center TextArea are set to the returned
     * Strings.
     * @param panel The panel to which the buttons should be added
     */
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

    /**
     * Method to set a layoutManager and a border to a panel, and a number of labels to it.
     * @param panel The panel which should be affected
     * @param mgr The desired LayoutManager
     * @param amount Number of JLabels to add
     */
    private void setupLabels(JPanel panel, LayoutManager mgr, int amount) {
        panel.setLayout(mgr);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        for(int i = 0; i < amount; i++) {
            panel.add(new JLabel("label " + (i+1) + " in this panel"));
        }
    }

    /**
     * Method to create a JList object containing String items
     * @return JList object with 6 items
     */
    private JList addList() {
        String[] numbers = {"List Item One", "List Item Two", "List Item Three", "List Item Four", "List Item Five",
                "List Item Six"};
        return new JList<>(numbers);
    }

    /**
     * Method to add a TextField, PasswordField and JList to a panel. TextField is set to add an Announcement text to
     * the center textArea if a matching string is provided and the PasswordField is set to add the password to the
     * textArea.
     * @param panel The panels which these things should be added to.
     */
    private void setupTextField(JPanel panel) {
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
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

    /**
     * Creates and returns a JPasswordField, which adds the password to the textArea after input and clears the field.
     * @return created JPasswordField
     */
    private JPasswordField addPasswordField() {
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.addActionListener(event -> {
            center.append(new String(passwordField.getPassword()) + "\n");
            passwordField.setText("");
        });
        return passwordField;
    }

    /**
     * Adds a button to the provided panel, which sets the textArea to the original welcome message.
     * @param panel panel to add button to
     */
    private void addWelcomeMessageButton(JPanel panel) {
        JButton welcomeButton = new JButton("Get Welcome Message");
        welcomeButton.addActionListener(event ->
                setWelcomeText());
        panel.add(welcomeButton);
    }

    /**
     * Sets up the center TextArea and adds it to a ScrollPane.
     * @param textArea textArea to setup
     */
    private void setupCenterText(JTextArea textArea) {
        setWelcomeText();
        textArea.setColumns(100);
        textArea.setFont(new Font("calibri", Font.BOLD, 16));
        textArea.setEditable(false);
        centerScrollPane = new JScrollPane(textArea);

    }

    /**
     * Sets a border and layoutManager to the provided panel, and calls methods responsible for creating and adding
     * functional buttons to the panel, along with creating descriptive labels in between.
     * @param panel Desired panel to affect
     */
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

    /**
     * Instantiates a danish and swedish factory and creates buttons for calling these factories' methods. The returned
     * Strings are appended to the center textArea
     * @param panel Desired panel to be affected
     */
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

    /**
     * Method to set the center areaText to the welcome message
     */
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

    /**
     * Instantiates a RadioShow, creates 3 observers, makes them follow the RadioShow and adds them to the RadioShow.
     * Creates a button, which calls the radioShows' update method, causing the observers to do radio broadcasts.
     * @param panel panel to add button to
     */
    private void addObserverButton(JPanel panel) {
        this.radioShow = new RadioShow();
        Observer radio1 = new RadioUnit("Transistor Radio");
        Observer radio2 = new RadioUnit("Car Radio");
        Observer radio3 = new RadioUnit("SmartPhone");
        radio1.followObservable(radioShow);
        radio2.followObservable(radioShow);
        radio3.followObservable(radioShow);
        radioShow.addObserver(radio1);
        radioShow.addObserver(radio2);
        radioShow.addObserver(radio3);

        var button = new JButton("Do a radio broadcast!");
        panel.add(button);
        button.addActionListener(event ->
                radioShow.update());

    }

    /**
     * Creates two objects subclassing TemplateDemo and creates two buttons, each calling one of the object's
     * outputInfo method. center textArea is set to the returned String
     * @param panel Panel which the buttons are added to
     */
    private void addTemplateButtons(JPanel panel) {
        TemplateDemo sub1 = new Sub1();
        TemplateDemo sub2 = new Sub2();

        var button1 = new JButton("Template button 1");
        panel.add(button1);
        button1.addActionListener(event -> center.setText(sub1.outputInfo()));

        var button2 = new JButton("Template button 2");
        panel.add(button2);
        button2.addActionListener(event -> center.setText(sub2.outputInfo()));
    }

    /**
     * Simply instantiates all the panels and the textArea
     */
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
