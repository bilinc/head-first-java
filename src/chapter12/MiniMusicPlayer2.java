package chapter12;

import javax.sound.midi.*;

public class MiniMusicPlayer2 implements ControllerEventListener {
  public static void main (String[] args) {
    MiniMusicPlayer2 mini2 = new MiniMusicPlayer2();
    mini2.go();
  }
  
  public void go() {
    try {
      // Make and open a sequencer
      Sequencer sequencer = MidiSystem.getSequencer();
      sequencer.open();
      
      // Register for events with the sequencer. The event registration method takes the listener AND an int array
      // representing the list of ControllerEvents you want. We want only one event, #127
      int[] eventsIWant = {127};
      sequencer.addControllerEventListener(this, eventsIWant);
    
      // Make a sequence and a track
      Sequence seq = new Sequence(Sequence.PPQ, 4);
      Track track = seq.createTrack();
    
      // Make events that goes from piano note 5 to piano note 61
      for (int i = 5; i < 61; i+= 4) {
        // Call makeEvent() method to make the message and event, then add the result (the MidiEvent returned from makeEvent())
        // to the track.
        track.add(makeEvent(144, 1, i, 100, i));             // NOTE ON (144)
  
        track.add(makeEvent(176, 1, 127, 100, i));      // Insert ControllerEvent we can listen for
        
        track.add(makeEvent(128, 1, i, 100, i + 2));    // NOTE OFF (128)
      }
    
      sequencer.setSequence(seq);
      sequencer.setTempoInBPM(120);
      sequencer.start();
    
    } catch (Exception e) { e.printStackTrace(); }
  }
  
  /**
   * The event handler method (from the ControllerEvent listener interface). Each time we get the even, we'll
   * print "la" to the command-line.
   */
  public void controlChange(ShortMessage event) {
    System.out.println("la");
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
  
}
