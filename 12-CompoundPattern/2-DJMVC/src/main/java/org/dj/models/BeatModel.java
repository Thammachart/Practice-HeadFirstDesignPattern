package org.dj.models;

import java.util.ArrayList;
import javax.sound.midi.*;

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
        notifyBPMObservers();
    }

    @Override
    public int getBPM() {
        return this.bpm;
    }

    @Override
    public void registerBeatObserver(BeatObserver observer) {
        this.beatObservers.add(observer);
    }

    public void notifyBeatObservers() {
        for(BeatObserver observer : this.beatObservers) {
            observer.updateBeat();
        }
    }

    @Override
    public void removeBeatObserver(BeatObserver observer) {
        this.beatObservers.remove(observer);
    }

    @Override
    public void registerBPMObserver(BPMObserver observer) {
        this.bpmObservers.add(observer);
    }

    public void notifyBPMObservers() {
        for(BPMObserver observer : this.bpmObservers) {
            observer.updateBPM();
        }
    }

    @Override
    public void removeBPMObserver(BPMObserver observer) {
        this.bpmObservers.remove(observer);
    }

    @Override
    public void meta(MetaMessage meta) {
        notifyBeatObservers();
        // if(meta.getType() == 47) {
        //
        //     sequencer.start();
        //     setBPM(getBPM());
        // }
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
