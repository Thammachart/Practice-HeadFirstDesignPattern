package org.dj.models;

import java.util.ArrayList;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.Track;
import javax.sound.midi.ShortMessage;

import org.dj.views.BeatObserver;
import org.dj.views.BPMObserver;

public class BeatModel implements BeatModelInterface, MetaEventListener {
    private Sequencer sequencer;
    private ArrayList<BeatObserver> beatObservers = new ArrayList<>();
    private ArrayList<BPMObserver> bpmObservers = new ArrayList<>();
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
        setBPM(90);
    }

    @Override
    public void off() {
        setBPM(0);
        sequencer.stop();
    }

    @Override
    public void setBPM(int bpm) {
        this.bpm = bpm;
        sequencer.setTempoInBPM(getBPM());
        notifyBPMObservers();
    }

    @Override
    public int getBPM() {
        return this.bpm;
    }

    void beatEvent() {
        notifyBeatObservers();
    }

    @Override
    public void registerObserver(BeatObserver observer) {
        this.beatObservers.add(observer);
    }

    public void notifyBeatObservers() {
        for(BeatObserver observer : this.beatObservers) {
            observer.updateBeat();
        }
    }

    @Override
    public void removeObserver(BeatObserver observer) {
        this.beatObservers.remove(observer);
    }

    @Override
    public void registerObserver(BPMObserver observer) {
        this.bpmObservers.add(observer);
    }

    public void notifyBPMObservers() {
        for(BPMObserver observer : this.bpmObservers) {
            observer.updateBPM();
        }
    }

    @Override
    public void removeObserver(BPMObserver observer) {
        this.bpmObservers.remove(observer);
    }

    @Override
    public void meta(MetaMessage meta) {
        if(meta.getType() == 47) {
            beatEvent();
            sequencer.start();
            setBPM(getBPM());
        }
    }

    public void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addMetaEventListener(this);
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
				track.add(makeEvent(128,9,key, 100, i+1));
			}
		}
	}

	public  MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);

		} catch(Exception e) {
			e.printStackTrace();
		}
		return event;
	}
}
