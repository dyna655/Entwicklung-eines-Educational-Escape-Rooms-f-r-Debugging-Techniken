package adastra.shield;

public class HeatShield {
     public static boolean isShieldActivated(int hullTemp, int solarFlareLevel, boolean ecoMode) {
         boolean criticalHeat = (hullTemp >= 800);
         boolean highRadiation = (solarFlareLevel == 5);

         // Sicherheitsprüfung bei gleichzeitiger Hitze und Strahlung
         if (criticalHeat && highRadiation) {
             if (ecoMode = true) {
                 return false; // Schild wird zur Energieeinsparung deaktiviert
             }
             return true;
         }
         return criticalHeat;
     }
}