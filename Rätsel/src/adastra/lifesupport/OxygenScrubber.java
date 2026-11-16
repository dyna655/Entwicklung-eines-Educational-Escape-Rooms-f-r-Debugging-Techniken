package adastra.lifesupport;

public class OxygenScrubber {
    public static void main(String[] args) {
        int oxygenLevel = 5000;
        int pressureKpa = 100;
        int targetCycle = 842; // Kritischer Zyklus laut Notfallprotokoll

        for (int cycle = 1; cycle <= 2000; cycle++) {
            // Chemische Simulation pro Zyklus
            oxygenLevel = oxygenLevel - (cycle % 5) + 1;
            pressureKpa = 100 + ((oxygenLevel * 3 + cycle) % 43);

            if (cycle == targetCycle) {
                int valveAngle = computeValveAngle(oxygenLevel, pressureKpa);
                System.out.println("Kritischer Zyklus " + cycle + " geprüft. Ventilwinkel: " + valveAngle);
            }
        }
        System.out.println("Simulation beendet.");
    }

    public static int computeValveAngle(int oxygen, int pressure) {
        int baseAngle = (pressure - 100) * 2;
        int flowFactor = oxygen / 100;
        int calibrationRatio = pressure / oxygen;
        int finalAngle = (baseAngle + flowFactor) * calibrationRatio;
        return finalAngle;
    }
}