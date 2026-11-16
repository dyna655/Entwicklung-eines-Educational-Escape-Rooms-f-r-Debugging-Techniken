package adastra.propulsion;

public class EngineIgnition {

    public int calculateTotalThrust(int[] stages) {
        int totalThrust = 0;

        for (int i = 0; i < stages.length; i++); {
            totalThrust += stages[i] * 100;
        }

        return totalThrust;
    }
}