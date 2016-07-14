package org.dj.models;

import javax.sound.midi.*;

public class BeatModel implements BeatModelInterface {
    private Sequencer sequencer;
    private int bpm = 90;
    private Sequence sequence;
    private Track track;

    @Override
    public void initialize() {
        setUpMidi();
        buildTrackAndStart();
    }

    @Override
    public void on() {
        sequencer.start();
        setBPM(bpm);
    }

    @Override
    public void off() {
        // setBPM(0);
        sequencer.stop();
    }

    @Override
    public void setBPM(int bpm) {
        this.bpm = bpm;
        sequencer.setTempoInBPM(getBPM());
    }

    @Override
    public int getBPM() {
        return this.bpm;
    }

    public void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ,4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(getBPM());
            sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void buildTrackAndStart() {
		int[] trackList = {35, 0, 46, 0};

		sequence.deleteTrack(null);
		track = sequence.createTrack();

		makeTracks(trackList);
		track.add(makeEvent(192,9,1,0,4));
		try {
			sequencer.setSequence(sequence);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void makeTracks(int[] list) {

		for (int i = 0; i < list.length; i++) {
			int key = list[i];

			if (key != 0) {
				track.add(makeEvent(144,9,key, 100, i));
                track.add(makeMetaMessageEvent(i));
				track.add(makeEvent(128,9,key, 100, i+1));
                track.add(makeMetaMessageEvent(i+1));
			}
		}
	}

	public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			// MetaMessage a = new MetaMessage();
            ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);

		} catch(Exception e) {
			e.printStackTrace();
		}
		return event;
	}

    public MidiEvent makeMetaMessageEvent(int tick) {
        MidiEvent event = null;
		try {
			MetaMessage a = new MetaMessage();
			event = new MidiEvent(a, tick);

		} catch(Exception e) {
			e.printStackTrace();
		}
		return event;
    }
}
