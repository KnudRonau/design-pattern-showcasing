package com.dt181g.project;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class Project {
    private Project() {}

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
