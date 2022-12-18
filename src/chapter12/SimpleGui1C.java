package chapter12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui1C implements ActionListener {  // an instance of SimpleGui1B IS-A ActionListener
  JButton button;
  JFrame frame;
  
  public static void main (String[] args) {
    SimpleGui1C gui = new SimpleGui1C();
    gui.go();
  }
  
  public void go() {
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    button = new JButton("Change colors");
    // says to the button "add me to your list of listeners"
    button.addActionListener(this);
    
    MyDrawPanel drawPanel = new MyDrawPanel();

    // Quits the program when you close the window
    frame.getContentPane().add(BorderLayout.SOUTH, button);
    frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    frame.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent event) {
    frame.repaint();
  }
}
