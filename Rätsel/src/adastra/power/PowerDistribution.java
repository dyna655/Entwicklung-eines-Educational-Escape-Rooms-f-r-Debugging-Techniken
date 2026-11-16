package adastra.power;

public class PowerDistribution {

    public int getSectorPriority(String sectorName) {
        if ("BRIDGE".equals(sectorName)) {
            return 1;
        } else if ("ENGINE".equals(sectorName)) {
            return 2;
        } else if ("LIFE_SUPPORT".equals(sectorName)) {
            return 3;
        }
    }
}