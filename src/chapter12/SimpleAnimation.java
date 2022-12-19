package chapter12;

import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {
  JFrame frame;
  int x = 70;
  int y = 70;
  
  public static void main(String[] args) {
    SimpleAnimation gui = new SimpleAnimation();
    gui.go();
  }
  
  public void go() {
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    MyDrawPanel drawPanel = new MyDrawPanel();
  
    frame.getContentPane().add(drawPanel);
    frame.setSize(500, 500);
    frame.setVisible(true);
    
    for (int i=1; i < 130; i++ ) {
      x++;
      y++;
      
      drawPanel.repaint();
      
      try {
        Thread.sleep(50);
      } catch (Exception e) { }
  
    }
    
  }
  
  class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
      g.setColor(Color.white);
      g.fillRect(0, 0, this.getWidth(), this.getHeight());
      
      g.setColor(Color.orange);
      g.fillOval(x, y, 100, 100);
    }
  }
}
