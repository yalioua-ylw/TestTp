package org.emp.gl.gui;


import org.emp.gl.TimeService.TimeServiceListener;
import org.emp.gl.player.Rebot;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class Environnement implements TimeServiceListener{
    static int x;
    static int y;

    static char[][] puzzle = {
            { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
            { '#', 'Y', ' ', ' ', '#', ' ', '#', '#', '#', '#' },
            { '#', '#', ' ', '#', '#', 'X', '#', ' ', ' ', '#'  },
            { '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ' },
            { '#', ' ', '#', ' ', ' ', '#', '#', '#', '#', ' ' },
            { '#', '#', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ' },
            { '#', ' ', ' ', ' ', ' ', '#', '#', ' ', ' ', '#' },
            { '#', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#' },
            { '#', ' ', '#', ' ', ' ', ' ', '#', '#', ' ', ' ', },
            { '#', ' ', '#', '#', ' ', '#', '#', ' ', '#', ' ' }};

    public Environnement(){
        initComponents();
    }
    private void initComponents(){
        JFrame mainFrame = new JFrame("Labyrinth");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(puzzle.length, puzzle[0].length));
        mainFrame.setLocationRelativeTo(null);
        for (int row = 0; row < puzzle.length; row++) {
            for (int col = 0; col < puzzle[0].length; col++) {
                JLabel label = makeLabel(puzzle[row][col]);
                mainFrame.add(label);
            }
        }
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private JLabel makeLabel(char c) {

        JLabel label= new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(40, 40));
        switch(c) {
            case '#':
                label.setBackground(Color.BLACK);
                break;
            case 'X':
                label.setBackground(Color.red);
                break;
            case 'Y':
                label.setBackground(Color.green);
                break;
            default:
                label.setBackground(Color.WHITE);
                break;

        }
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        return label;
    }

    private void moveUp(){
        findPosition();
        if(x>0){
            if(puzzle[x-1][y]!='#'){
                if(puzzle[x-1][y]=='Y'){
                    successGui();
                }
                puzzle[x][y]=' ';
                x=x-1;
                puzzle[x][y]='X';
                System.out.println("position changed to up");
                initComponents();
            }
        }

    }

    private void successGui() {
        JFrame frame=new JFrame("success");
        frame.setSize(200,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextPane text=new JTextPane();
        text.setText("Success");
        frame.add(text);
        frame.pack();
        frame.setVisible(true);
    }

    private void moveDown(){
        findPosition();
        if(x!=9){
            if(puzzle[x+1][y]!='#'){
                if(puzzle[x+1][y]=='Y'){
                    successGui();
                }
                puzzle[x][y]=' ';
                x=x+1;
                puzzle[x][y]='X';
                System.out.println("position changed to down");
                initComponents();
            }
        }

    }
    private void moveLeft(){
        findPosition();
        if(y!=0){
            if(puzzle[x][y-1]!='#'){
                if(puzzle[x][y-1]=='Y'){
                    successGui();
                }
                puzzle[x][y]=' ';
                y=y-1;
                puzzle[x][y]='X';
                System.out.println("position changed to the left");
                initComponents();
            }
        }
    }
    private void moveRight(){
        findPosition();
        if(x!=9){
            if(puzzle[x][y+1]!='#'){
                if(puzzle[x][y+1]=='Y'){
                    successGui();
                }
                puzzle[x][y]=' ';
                y=y+1;
                puzzle[x][y]='X';
                System.out.println("position changed to the right");
                initComponents();
            }
        }
    }
    static void findPosition(){
        for (int row = 0; row < puzzle.length; row++) {
            for (int col = 0; col < puzzle[0].length; col++) {
                if(puzzle[row][col]=='X'){
                    x=row;
                    y=col;
                }
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName()==TimeServiceListener.SECOND){
            move();
        }
    }
    public void move(){
        if(Rebot.getInstance().direction=="left"){
            moveLeft();
        }
        if(Rebot.getInstance().direction=="right"){
            moveRight();
        }
        if(Rebot.getInstance().direction=="up"){
            moveUp();
        }
        if(Rebot.getInstance().direction=="down"){
            System.out.println("run");
            moveDown();
        }
    }
}
