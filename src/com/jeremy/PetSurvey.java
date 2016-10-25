package com.jeremy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PetSurvey extends JFrame{
    //creating the variables for the GUI
    private JPanel rootPane;
    private JCheckBox dogCheckBox;
    private JCheckBox catCheckBox;
    private JCheckBox fishCheckBox;
    private JButton quitButton;
    private JLabel resultsLabel;

    private boolean dog;
    private boolean cat;
    private boolean fish;

    protected PetSurvey() {
        //setting the content to be displayed for the GUI
        setContentPane(rootPane);
        pack();
        setSize(new Dimension(850, 600));
        setTitle("Pet Survey");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        //adding fish if checked
        fishCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fish = fishCheckBox.isSelected();
                updateResults();

            }
        });
        //adding dog if checked
        dogCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dog = dogCheckBox.isSelected();
                updateResults();

            }
        });
        //adding cat if checked
        catCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cat = catCheckBox.isSelected();
                updateResults();

            }
        });

        //a quit button that also asked the user of they are sure they want to quit
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(PetSurvey.this, "Are you sure you want to quit?",
                        "Quit", JOptionPane.OK_CANCEL_OPTION);
                if (quit == JOptionPane.OK_OPTION){
                    System.exit(0);
                }


            }
        });

    }
//method to update the results once the check box is checked
private void updateResults(){
    String hasDog = dog ? "one dog" : "no dogs";
    String hasCat = cat ? "one cat" : "no cats";
    String hasFish = fish ? "one fish" : "no fish";

    String results = "you have " + hasDog + " and " + hasCat + " and " + hasFish ;
    resultsLabel.setText(results);
}

}
