/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author helmi
 */

public class mains extends JFrame {

    private static final String COMMIT_ACTION = "commit";

    public static void main(String args[]) {

        final JTextField mainTextField = new JTextField();

// Without this, cursor always leaves text field
        mainTextField.setFocusTraversalKeysEnabled(false);

// Our words to complete
        ArrayList<String> keywords = new ArrayList<String>(5);
        keywords.add("example");
        keywords.add("autocomplete");
        keywords.add("stackabuse");
        keywords.add("java");
        keywords.add("javz");
        demo autoComplete = new demo(mainTextField, keywords);
        mainTextField.getDocument().addDocumentListener(autoComplete);

// Maps the tab key to the commit action, which finishes the autocomplete
// when given a suggestion
        mainTextField.getInputMap().put(KeyStroke.getKeyStroke("TAB"), COMMIT_ACTION);
        mainTextField.getActionMap().put(COMMIT_ACTION, autoComplete.new CommitAction());
        mainTextField.setText("hello wrerfsd");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mains s = new mains();
                LayoutManager FlowLayout = new FlowLayout(4);

                FlowLayout.addLayoutComponent("he", mainTextField);
                s.setLayout(FlowLayout);
                s.add(mainTextField);
                s.setVisible(true);

            }
        });
    }
}
