package br.com.alura.screenmatch.calculations;

import br.com.alura.screenmatch.models.Title;

public class TimeCalculator {
    private int totalTime;

    public int getTotalTime() {
        return this.totalTime;
    }

    public void includes(Title t) {
        this.totalTime += t.getDurationInMinutes();
    }
}
