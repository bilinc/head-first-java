package chapter12;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui1B implements ActionListener {  // an instance of SimpleGui1B IS-A ActionListener
  JButton button;
  
  public static void main (String[] args) {
    SimpleGui1B gui = new SimpleGui1B();
    gui.go();
  }
  
  public void go() {
    JFrame frame = new JFrame();
    button = new JButton("click me");
    
    // says to the button "add me to your list of listeners"
    button.addActionListener(this);

    // Quits the program when you close the window
    frame.getContentPane().add(button);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    frame.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent event) {
    button.setText("I've been clicked!!!");
  }
}
