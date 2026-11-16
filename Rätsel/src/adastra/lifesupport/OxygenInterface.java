package adastra.lifesupport;

public class OxygenInterface {

    public double evaluateOxygenFlow(int baseRate, String sector) {

        double multiplier = fetchSectorMultiplier(String sector);

        double safetyBonus = calculateSafetyLimit(String sector, int baseRate);

        return (baseRate * multiplier) + safetyBonus;
    }

    private double fetchSectorMultiplier(String sector) {
        if ("SECTOR-A".equals(sector)) {
            return 1.5;
        }
        return 1.0;
    }

    private double calculateSafetyLimit(int limit, String mode) {
        return limit > 50 ? 5.0 : 0.0;
    }
}