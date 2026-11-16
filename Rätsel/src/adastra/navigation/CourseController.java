package adastra.navigation;

class Thruster {
    public int power;
    public Thruster(int power) { this.power = power; }
}

public class CourseController {
    public static void main(String[] args) {
        Thruster port = new Thruster(20);      // Backbord-Düse
        Thruster starboard = new Thruster(30); // Steuerbord-Düse
        int[] corrections = { 10, 15, 20, 5 };

        for (int i = 0; i < corrections.length - 1; i++) {
            port.power += corrections[i];
            if (port.power >= 45) {
                // Synchronisiere Steuerbord mit Backbord
                starboard = port;
            }
            starboard.power += 5;
        }
        System.out.println(port.power + "-" + starboard.power);
    }
}