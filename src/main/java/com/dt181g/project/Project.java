package com.dt181g.project;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

/**
 * Entity acting as a starting point for the project.
 * @author Knud Ronau Larsen
 */
public class Project {
    private Project() {}

    /**
     * Method to start an EDT Thread, which instantiates a new MainFrame, sets its title, default close operation, and
     * sets is visible. Additionally it creates a new Engine and calls its start method.
     * @param args not relevant
     */
    public static void main(final String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new MainFrame();
            frame.setTitle("Main frame for program");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        });
        new Engine().start();
    }
}
