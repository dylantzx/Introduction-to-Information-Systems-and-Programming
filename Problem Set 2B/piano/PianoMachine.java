package com.example.problemset2b.piano;

import com.example.problemset2b.midi.Instrument;
import com.example.problemset2b.midi.Midi;
import com.example.problemset2b.music.NoteEvent;
import com.example.problemset2b.music.Pitch;

import java.util.ArrayList;

import javax.sound.midi.MidiUnavailableException;

import static com.example.problemset2b.midi.Midi.DEFAULT_INSTRUMENT;

public class PianoMachine {

    private Midi midi;
    public ArrayList<Pitch> keyPressed = new ArrayList<>();
    public Instrument nextInstrument = DEFAULT_INSTRUMENT;
    public int transpose = 0;
    public static final int octave = 12;
    public ArrayList<NoteEvent> NEA = new ArrayList<>();
    public boolean togglerecord = false;
    public long play;
    public int duration;

    /**
     * constructor for PianoMachine.
     *
     * initialize midi device and any other state that we're storing.
     */
    public PianoMachine() {
        try {
            midi = Midi.getInstance();
        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
            return;
        }
    }

    public void beginNote(Pitch rawPitch) {
        if (keyPressed.contains(rawPitch) == false) {
            keyPressed.add(rawPitch);
            midi.beginNote(rawPitch.transpose(octave*transpose).toMidiFrequency(),nextInstrument);
            NEA.add(new NoteEvent(rawPitch.transpose(octave*transpose), System.currentTimeMillis(),nextInstrument, NoteEvent.Kind.start));
        }
    }

    public void endNote(Pitch rawPitch) {
        if (keyPressed.contains(rawPitch)) {
            keyPressed.remove(rawPitch);
            midi.endNote(rawPitch.transpose(octave*transpose).toMidiFrequency(),nextInstrument);
            NEA.add(new NoteEvent(rawPitch.transpose(octave*transpose), System.currentTimeMillis(),nextInstrument, NoteEvent.Kind.stop));
        }
    }

    public void changeInstrument() {
        nextInstrument = nextInstrument.next();
    }

    public void shiftUp() {
        if (transpose <2) transpose++;
    }


    public void shiftDown() {
        if (transpose > -2) transpose--;
    }


    public boolean toggleRecording() {
        if (togglerecord) {
            // If recording, stop recording
            togglerecord = false;
            return false;
        } else {
            // If not recording, start recording
            NEA.clear();
            togglerecord = true;
            return true;
        }

    }

    public void playback() {
        play = NEA.get(0).getTime();
        for (NoteEvent key : NEA) {
            duration = (int) (key.getTime() - play) / 10;
            Midi.rest(duration);
            if (key.getKind() == NoteEvent.Kind.start) {
                midi.beginNote(key.getPitch().toMidiFrequency(), key.getInstr());
            }
            else {
                midi.endNote(key.getPitch().toMidiFrequency(), key.getInstr());
            }
            play = key.getTime();
        }

    }

}
