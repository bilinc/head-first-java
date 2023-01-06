package chapter12;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer3 {
  
  static JFrame f = new JFrame("My First Music Video");
  static MyDrawPanel ml;
  
  public static void main (String[] args) {
    MiniMusicPlayer3 mini3 = new MiniMusicPlayer3();
    mini3.go();
  }
  
  public void setUpGui() {
    ml = new MyDrawPanel();
    f.setContentPane(ml);
    f.setBounds(30, 30, 300, 300);
    f.setVisible(true);
  }
  
  public void go() {
    setUpGui();
    
    try {
      // Make and open a sequencer
      Sequencer sequencer = MidiSystem.getSequencer();
      sequencer.open();
      
      // Register for events with the sequencer. The event registration method takes the listener AND an int array
      // representing the list of ControllerEvents you want. We want only one event, #127
      sequencer.addControllerEventListener(ml, new int[] {127});
    
      // Make a sequence and a track
      Sequence seq = new Sequence(Sequence.PPQ, 4);
      Track track = seq.createTrack();
    
      int r = 0;
      // Make events that goes from piano note 5 to piano note 61
      for (int i = 0; i < 60; i+= 4) {
        
        r = (int) ((Math.random() * 50)  + 1);
        // Call makeEvent() method to make the message and event, then add the result (the MidiEvent returned from makeEvent())
        // to the track.
        track.add(makeEvent(144, 1, r, 100, i));             // NOTE ON (144)
  
        track.add(makeEvent(176, 1, 127, 100, i));      // Insert ControllerEvent we can listen for
        
        track.add(makeEvent(128, 1, r, 100, i + 2));    // NOTE OFF (128)
      }
    
      sequencer.setSequence(seq);
      sequencer.setTempoInBPM(120);
      sequencer.start();
    
    } catch (Exception e) { e.printStackTrace(); }
  }
  
  public MidiEvent makeEvent(int comb, int chan, int one, int two, int tick) {
    MidiEvent event = null;
    try {
      ShortMessage a = new ShortMessage();
      a.setMessage(comb, chan, one, two);
      event = new MidiEvent(a, tick);
    } catch (Exception e) { }
  
    return event;
  }
  
  class MyDrawPanel extends JPanel implements ControllerEventListener {
    boolean msg = false;
    
    public void controlChange(ShortMessage event) {
      msg = true;
      repaint();
    }
    
    public void paintComponent(Graphics g) {
      if (msg) {
        
        int r = (int) (Math.random() * 250);
        int gr = (int) (Math.random() * 250);
        int b = (int) (Math.random() * 250);
        
        g.setColor(new Color(r,gr,b));
        
        int ht = (int) ((Math.random() * 120) + 10);
        int width = (int) ((Math.random() * 120) + 10);
  
        int x = (int) ((Math.random() * 40) + 10);
        int y = (int) ((Math.random() * 40) + 10);
        
        g.fillRect(x,y,ht,width);
        msg = false;
        
      }
    }
  }
  
}
