package chapter12;

import javax.swing.*;

public class SimpleGui1 {
  public static void main (String[] args) {
    JFrame frame = new JFrame();
    JButton button = new JButton("click me");
  
    // Quits the program when you close the window
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
    frame.getContentPane().add(button);
  
    frame.setSize(300, 300);
  
    frame.setVisible(true);
  }
}
