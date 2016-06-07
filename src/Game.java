/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matr
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener {
    
    static int imgx = 200;
    static int imgy = 20;
    JFrame fen = new JFrame();
    JPanel pan = new JPanel();
    JLabel img = new JLabel();
    
    public void display() {
        
        fen.add(pan);
        fen.addKeyListener(this);
        fen.setResizable(false);
        fen.setTitle("Le Jeu 2D");
        img.setText("Coucou");
        pan.add(img);
        pan.setBackground(Color.yellow);
        fen.setVisible(true);
        fen.setSize(480, 272);
    }
    
    public static void main(String[] args) {
        Game disp = new Game();
        disp.display();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
           imgx -= 10;
           
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
           imgx += 10;
          
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
           imgy -= 10;
          
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
           imgy += 10;
           
        }
        img.setBounds(imgx, imgy, 200, 20);
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
