package chapter12;

import javax.sound.midi.*;

public class MiniMusicPlayer1 {
  
  public static void main(String[] args) {
    
    try {
      // Make and open a sequencer
      Sequencer sequencer = MidiSystem.getSequencer();
      sequencer.open();
      
      // Make a sequence and a track
      Sequence seq = new Sequence(Sequence.PPQ, 4);
      Track track = seq.createTrack();
      
      // Make events that goes from piano note 5 to piano note 61
      for (int i = 5; i < 61; i+= 4) {
        // Call makeEvent() method to make the message and event, then add the result (the MidiEvent returned from makeEvent())
        // to the track. These are NOTE ON (144) and NOTE OFF (128) pairs
        track.add(makeEvent(144, 1, i, 100, i));
        track.add(makeEvent(128, 1, i, 100, i + 2));
      }
      
      sequencer.setSequence(seq);
      sequencer.setTempoInBPM(120);
      sequencer.start();
      
    } catch (Exception e) { e.printStackTrace(); }
  }
  
  public static MidiEvent makeEvent(int comb, int chan, int one, int two, int tick) {
    MidiEvent event = null;
    try {
      ShortMessage a = new ShortMessage();
      a.setMessage(comb, chan, one, two);
      event = new MidiEvent(a, tick);
    } catch (Exception e) { }
    
    return event;
  }
}
