package battleships;

import battleships.ship.Battleship;
import battleships.ship.SimpleShip;

public class ShipDemo {
    public static void main() {
        Ship s = new Battleship();

        System.out.println(s);
        s.rotate();
        System.out.println(s);

    }
}
