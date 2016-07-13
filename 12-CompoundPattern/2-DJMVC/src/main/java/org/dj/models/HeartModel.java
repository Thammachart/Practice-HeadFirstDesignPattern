package org.dj.models;

import java.util.ArrayList;
import java.util.Random;

import org.dj.views.BeatObserver;
import org.dj.views.BPMObserver;

public class HeartModel implements HeartModelInterface, Runnable {
    private ArrayList<BeatObserver> beatObservers;
    private ArrayList<BPMObserver> bpmObservers;
    int time = 1000;
    int bpm = 90;
    Random random;
    Thread thread;

    public HeartModel() {
        this.beatObservers = new ArrayList<>();
        this.bpmObservers = new ArrayList<>();

        random = new Random(System.currentTimeMillis());

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        int lastRate = -1;

        while(true) {
            int change = random.nextInt(20);
            if(random.nextInt(2) == 0) {
                change = -change;
            }
            int rate = 60000/(time + change);
            if(rate < 120 && rate > 50) {
                time += change;
                notifyBeatObservers();
                if(rate != lastRate){
                    lastRate = rate;
                    notifyBPMObservers();
                }
            }
            try {
                Thread.sleep(time);
            } catch(Exception e) {}
        }
    }

    public int getHeartRate() {
        return 60000/time;
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
}
