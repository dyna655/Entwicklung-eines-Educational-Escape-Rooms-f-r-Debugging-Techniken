package adastra.airlock;

import java.util.ArrayList;
import java.util.List;

class PressureRecord {
    public int pressure;
    public PressureRecord(int p) { this.pressure = p; }
}

public class AirlockBuffer {
    private List<PressureRecord> history = new ArrayList<>();
    private PressureRecord current = new PressureRecord(0);

    public void logPressure(int newPressure) {
        current.pressure = newPressure;
        history.add(current);
    }

    public List<PressureRecord> getHistory() { return history; }
}