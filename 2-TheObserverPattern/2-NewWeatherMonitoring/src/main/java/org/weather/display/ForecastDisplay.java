package org.weather.display;

import java.util.Observable;
import java.util.Observer;

import org.weather.WeatherData;

public class ForecastDisplay implements DisplayElement, Observer {
    private Observable observable;
    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg) {
        if(observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData)observable;
            lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.print("Forecast: ");
        if(lastPressure < currentPressure)
            System.out.println("Improving weather on the way!");
        else if(lastPressure > currentPressure)
            System.out.println("Watch out for cooler, rainy weather");
        else
            System.out.println("More of the same");
    }
}
