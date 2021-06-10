package org.emp.gl.gui;

import org.emp.gl.player.Rebot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeSupport;

public class GameControler  {

    private JButton upButton;
    private JButton downButton;
    private JButton rightButton;
    private JButton leftButton;
    private JFrame frame;
    private JButton text;
    PropertyChangeSupport pcs=new PropertyChangeSupport(this);

    public GameControler(){
        initComponents();

    }

    void initComponents(){
        frame=new JFrame("Controleur");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 2));
        upButton=new JButton("Up");
        upButton.setSize(40,40);

        downButton=new JButton("Down");
        downButton.setSize(40,40);
        leftButton=new JButton("Left");
        leftButton.setSize(40,40);
        rightButton=new JButton("Right");
        rightButton.setSize(40,40);
        upButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Rebot.getInstance().direction!="down"){
                    Rebot.getInstance().direction="up";
                    text.setText("Direction="+ Rebot.getInstance().direction);
                }


            }
        });
        downButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Rebot.getInstance().direction!="up"){
                    Rebot.getInstance().direction="down";
                    text.setText("Direction="+ Rebot.getInstance().direction);
                }

            }
        });
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(Rebot.getInstance().direction!="right"){
                    Rebot.getInstance().direction="left";
                    text.setText("Direction="+ Rebot.getInstance().direction);
                }

            }
        });
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Rebot.getInstance().direction!="left"){
                    Rebot.getInstance().direction="right";
                    text.setText("Direction="+ Rebot.getInstance().direction);
                }

            }
        });
        frame.add(upButton);
        frame.add(downButton);
        frame.add(leftButton);
        frame.add(rightButton);
        text=new JButton("Direction="+ Rebot.getInstance().direction);
        text.setSize(60,40);
        frame.add(text);
        frame.pack();
        frame.setVisible(true);
    }

 
}
