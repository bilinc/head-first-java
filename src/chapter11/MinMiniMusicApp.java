package chapter11;

import javax.sound.midi.*;

public class MinMiniMusicApp {
  
  public static void main(String[] args) {
    MinMiniMusicApp mini = new MinMiniMusicApp();
    mini.play();
  }
  
  public void play() {
    try {
      // Get a Sequencer and open it
      Sequencer player = MidiSystem.getSequencer();
      player.open();
      
      Sequence seq = new Sequence(Sequence.PPQ, 4);
      
      // Ask the Sequencer for a Track. The Track lives in the Sequence, and the MIDI data lives in the track.
      Track track = seq.createTrack();
      
      // Change instrument
      ShortMessage firstMessage = new ShortMessage();
      firstMessage.setMessage(192, 1, 102, 0);
      MidiEvent firstNote = new MidiEvent(firstMessage, 1);
      track.add(firstNote);
      
      // Put some MIDI events into trhe Track.
      ShortMessage a = new ShortMessage();
      a.setMessage(144, 1, 100, 80);
      MidiEvent noteOn = new MidiEvent(a, 1);
      track.add(noteOn);
      
      ShortMessage b = new ShortMessage();
      b.setMessage(128, 1, 44, 100);
      MidiEvent noteOff = new MidiEvent(b, 3);
      track.add(noteOff);
      
      // Give the Sequence to the Sequencer
      player.setSequence(seq);
      
      // Start the Sequencer
      player.start();
      
    } catch(Exception ex) {
      ex.printStackTrace();
      
    }
  }
}
