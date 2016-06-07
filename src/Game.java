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
import java.util.Timer;
import java.util.TimerTask;

public class Game extends JPanel implements KeyListener {
    
    int imgx = 200;
    int imgy = 20;
    int iix = 10;
    int iiy = 10;
    JFrame fen = new JFrame();
    JLabel img = new JLabel();
    ImageIcon ii = new ImageIcon("./perso.png");
    Image im;
    
    public void display() {
        
        fen.add(this);
        fen.setDefaultCloseOperation(fen.EXIT_ON_CLOSE);
        fen.addKeyListener(this);
        fen.setResizable(false);
        fen.setTitle("Le Jeu 2D");
        img.setForeground(Color.DARK_GRAY);
        img.setText("ME");
        add(img);
        im = ii.getImage();
        setBackground(Color.yellow);
        repaint();
        fen.setVisible(true);
        fen.setSize(480, 272);
    }
    
    public void gravity() {
        if(imgy <= 210) {
            imgy += 1;
        }
        img.setBounds(imgx, imgy, 200, 20);
        collide();
    }
    
    public void collide() {
        
        if(imgx >= iix && imgx <= iix + 70 && imgy <= iiy + 70) {
            System.out.println("Game Over");
            imgx = 200;
            imgy = 20;
            img.setBounds(imgx, imgy, 200, 20);
        }
    }
    
    
    public static void main(String[] args) {
        Game disp = new Game();
        disp.display();
        Timer tm = new Timer();
        tm.schedule(new TimerTask() {
            @Override
            public void run() {
                disp.gravity();
            }
        }, 10, 10);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
           imgx -= 10;
           //iix -= 10;
           
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
           imgx += 10;
           //iix += 10;
          
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
           imgy -= 30;
           //iiy -= 10;
          
        }
        
        img.setBounds(imgx, imgy, 200, 20);
        repaint();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(ii.getImage(), iix, iiy, this); 
        g.setColor(Color.green);
        g2d.fillRect(0, 230, 480, 50);
    }
    
}